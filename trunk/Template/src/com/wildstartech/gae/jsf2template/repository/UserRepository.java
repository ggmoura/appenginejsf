package com.wildstartech.gae.jsf2template.repository;


import java.util.List;

import com.wildstartech.gae.jsf2template.entidade.User;
import com.wildstartech.gae.jsf2template.exception.RepositoryException;

/**
 * Persistence operations for users.
 * @author Rafael Nunes
 *
 */
public interface UserRepository {

	/**
	 * Get user by his username and password(a.k.a authenticate user)
	 * @param username
	 * @param password
	 * @return
	 * @throws RepositoryException 
	 */
	User getUserByLoginAndPassword(String username, String password) throws RepositoryException;

	void addUser(User user) throws RepositoryException;

	List<User> getAll() throws RepositoryException;

	User getUserById(long id) throws RepositoryException;

	void removeUser(User user2) throws RepositoryException;

	User findUserByEmail(String mail) throws RepositoryException;
}
