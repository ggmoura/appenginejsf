package com.wildstartech.gae.jsf2template.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.images.Image;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.Transform;

import com.wildstartech.gae.jsf2template.entidade.User;
import com.wildstartech.gae.jsf2template.exception.ServiceException;
import com.wildstartech.gae.jsf2template.ioc.ServiceFactory;
import com.wildstartech.gae.jsf2template.service.UserService;

public class BlobstoreServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService;

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		String action = request.getParameter("action");
		BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();

		if("upload".equals(action)) {
			Map<String, BlobKey> blobs = blobstoreService.getUploadedBlobs(request);
			BlobKey bKey = blobs.get("photoUrl");
			String idUser = request.getParameter("id");
			userService = ServiceFactory.getService(UserService.class);

			try {
				User user2 = userService.getUserById(Long.valueOf(idUser));
				if(user2.getAvatar() != null) {
					blobstoreService.delete(user2.getAvatar());
				}

				user2.setAvatar(bKey);

			} catch (ServiceException e) {
				e.printStackTrace();
				throw new ServletException("Erro no upload");
			}

			response.sendRedirect("/struts/list");
		}else if("getPhoto".equals(action)) {

			String blobk = request.getParameter("blob-key");

			BlobKey blobKey = new BlobKey(blobk);

			blobstoreService.serve(blobKey, response);
		}else if("resize".equals(action)) {
			ImagesService imgService = ImagesServiceFactory.getImagesService();
			InputStream stream = request.getInputStream();
			ArrayList<Byte> bytes = new ArrayList<Byte>();
			int b = 0;
			while((b = stream.read()) != -1){
				bytes.add((byte)b);
			}

			byte img[] = new byte[bytes.size()];
			for (int i = 0; i < bytes.size(); i++) {
				img[i] = bytes.get(i);
			}

			Image oldImage = ImagesServiceFactory.makeImage(img);
			Transform resize = ImagesServiceFactory.makeResize(340, 226);

			Image imgNew = imgService.applyTransform(resize, oldImage);

			response.getOutputStream().write(imgNew.getImageData());
			response.getOutputStream().close();
		}

	}


	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		processRequest(req, resp);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		processRequest(req, resp);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPut(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		processRequest(req, resp);
	}

}
