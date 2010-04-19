package com.wildstartech.gae.jsf2template.entidade;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;


@ManagedBean(name="usuarioBean")
public class UserBean {

	private User usuario;
	
	
	
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
