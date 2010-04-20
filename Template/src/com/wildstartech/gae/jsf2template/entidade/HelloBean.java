package com.wildstartech.gae.jsf2template.entidade;

import java.util.Date;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="helloBean")
public class HelloBean {

	private String texto;
	private Date data;


	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

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