package com.wildstartech.gae.jsf2template.service;

import java.util.List;

import com.wildstartech.gae.jsf2template.entidade.User;
import com.wildstartech.gae.jsf2template.exception.RepositoryException;
import com.wildstartech.gae.jsf2template.exception.ServiceException;
import com.wildstartech.gae.jsf2template.ioc.ServiceFactory;
import com.wildstartech.gae.jsf2template.repository.UserRepository;

/**
 * Implementation of UserService
 * @author Gleidson Moura
 *
 */
public class UserServiceImpl implements UserService {
	UserRepository userRepository;

	@Override
	public User authenticate(String username, String password) throws ServiceException {
		User user = null;
		try {
			userRepository = ServiceFactory.getService(UserRepository.class);
			user = userRepository.getUserByLoginAndPassword(username, password);
		} catch (RepositoryException e) {
			//TODO log this
			throw new ServiceException("Usuário/Senha inválido");
		}
		return user;
	}

	/* (non-Javadoc)
	 * @see br.com.yaw.service.UserService#addUser(br.com.yaw.entity.User)
	 */
	@Override
	public void addUser(User user) throws ServiceException {
		try {
			userRepository = ServiceFactory.getService(UserRepository.class);
			userRepository.addUser(user);
		} catch (RepositoryException e) {
			//TODO log this
			throw new ServiceException(e);
		}

	}

	/* (non-Javadoc)
	 * @see br.com.yaw.service.UserService#getAll()
	 */
	@Override
	public List<User> getAll() throws ServiceException {
		List<User> users = null;
		try {
			userRepository = ServiceFactory.getService(UserRepository.class);
			users = userRepository.getAll();
		} catch (RepositoryException re) {
			//TODO log this
			throw new ServiceException(re);
		}
		return users;
	}

	/* (non-Javadoc)
	 * @see br.com.yaw.service.UserService#getUserById(long)
	 */
	@Override
	public User getUserById(Long id) throws ServiceException {
		User user = null;
		try {
			userRepository = ServiceFactory.getService(UserRepository.class);
			user = userRepository.getUserById(id);
		} catch (RepositoryException re) {
			// TODO: log this
			throw new ServiceException(re);
		}
		return user;

	}

	/* (non-Javadoc)
	 * @see br.com.yaw.service.UserService#removeUser(br.com.yaw.entity.User)
	 */
	@Override
	public void removeUser(User user2) throws ServiceException {
		try {
			userRepository = ServiceFactory.getService(UserRepository.class);
			userRepository.removeUser(user2);
		} catch (RepositoryException e) {
			//TODO log this
			throw new ServiceException(e);
		}

	}

	/* (non-Javadoc)
	 * @see br.com.yaw.service.UserService#getByEmail(java.lang.String)
	 */
	@Override
	public User getUserByEmail(String mail) throws ServiceException {
		User us = null;
		try {
			userRepository = ServiceFactory.getService(UserRepository.class);
			us = userRepository.findUserByEmail(mail);
		} catch (RepositoryException e) {
			//TODO log this
			throw new ServiceException(e);
		}
		return us;
	}



}

