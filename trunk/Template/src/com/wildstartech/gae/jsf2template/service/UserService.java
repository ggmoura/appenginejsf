package com.wildstartech.gae.jsf2template.service;

import java.util.List;

import com.wildstartech.gae.jsf2template.entidade.User;
import com.wildstartech.gae.jsf2template.exception.ServiceException;


/**
 * Interface that handle the services for users.
 * @author Rafael Nunes
 *
 */
public interface UserService {

	User authenticate(String username, String password) throws ServiceException;

	void addUser(User user) throws ServiceException;

	List<User> getAll() throws ServiceException;

	User getUserById(Long id) throws ServiceException;

	void removeUser(User user2) throws ServiceException;

	User getUserByEmail(String mail) throws ServiceException;

}

