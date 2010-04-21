package com.wildstartech.gae.jsf2template.entidade;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import com.wildstartech.gae.jsf2template.exception.RepositoryException;
import com.wildstartech.gae.jsf2template.exception.ServiceException;
import com.wildstartech.gae.jsf2template.service.UserServiceImpl;


@ManagedBean(name="usuarioBean")
public class UserBean {

	private User usuario;

	public void add() {
		UserServiceImpl service = new UserServiceImpl();

		try {
			service.addUser(usuario);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}

	@PostConstruct
	public void init() 	{
		usuario = new User();
		usuario.setContactEmail("gleidson.gmoura@gmail.com");
		usuario.setPassword("segredo");
		usuario.setName("Gleidson Guimarães Moura");
		usuario.setPerfil(new Integer(10));
	}

	public User getUsuario() {
		return usuario;
	}


}
