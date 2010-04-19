package com.wildstartech.gae.jsf2template.entidade;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="helloBean")
public class HelloBean {

	private String texto;


	public void testar() {
		System.out.println("Chamando HelloBean.testar(). Texto = " + texto);
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}