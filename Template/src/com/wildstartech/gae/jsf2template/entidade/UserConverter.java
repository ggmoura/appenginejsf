package com.wildstartech.gae.jsf2template.entidade;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass=User.class)
public class UserConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		User usuario = new User();
		usuario.setName(value);
		return usuario;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object objeto) {
		return objeto.toString();
	}

}