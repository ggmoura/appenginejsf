package com.wildstartech.gae.jsf2template.entidade;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.datastore.Key;

/**
 * A generic app User.
 * @author Gleidson Moura
 *
 */
@Entity
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Key key;

	private String name;

	private String password;

	private String contactEmail;

	private String description;

	private String url;

	private Integer perfil;

	private BlobKey avatar;

	@Transient
	private String tags;

	public User() {}



	public User(String name, String password, String contactEmail, String description,
			String url, Integer perfil) {
		super();
		this.name = name;
		this.password = password;
		this.contactEmail = contactEmail;
		this.description = description;
		this.url = url;
		this.perfil = perfil;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public Integer getPerfil() {
		return perfil;
	}

	public void setPerfil(Integer perfil) {
		this.perfil = perfil;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}


	public BlobKey getAvatar() {
		return avatar;
	}

	public void setAvatar(BlobKey avatar) {
		this.avatar = avatar;
	}

}
