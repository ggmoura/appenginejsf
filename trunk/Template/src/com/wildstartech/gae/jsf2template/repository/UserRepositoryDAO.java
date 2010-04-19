package com.wildstartech.gae.jsf2template.repository;


import com.wildstartech.gae.jsf2template.entidade.User;
import com.wildstartech.gae.jsf2template.exception.RepositoryException;

/**
 * Implementation of repository
 * @author Rafael Nunes
 *
 */
public class UserRepositoryDAO extends BaseDAO<User, Long> implements UserRepository{

	@Override
	public User getUserByLoginAndPassword(String username, String password) throws RepositoryException {
		String hql = "select u from User u where u.contactEmail = :user and u.password = :pass"; //poderia ser trocado por NamedQueries ou buscar de um arquivo
		addParamToQuery("user", username);
		addParamToQuery("pass", password);

		return (User)executeQueryOneResult(hql, paramsToQuery);
	}

	/* (non-Javadoc)
	 * @see br.com.yaw.repository.UserRepository#addUser(br.com.yaw.entity.User)
	 */
	@Override
	public void addUser(User user) throws RepositoryException {
		save(user);
	}

	/* (non-Javadoc)
	 * @see br.com.yaw.repository.UserRepository#getUserById(long)
	 */
	@Override
	public User getUserById(long id) throws RepositoryException {
		return getByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see br.com.yaw.repository.UserRepository#removeUser(br.com.yaw.entity.User)
	 */
	@Override
	public void removeUser(User user2) throws RepositoryException {
		delete(user2);

	}

	/* (non-Javadoc)
	 * @see br.com.yaw.repository.UserRepository#findUserByEmail(java.lang.String)
	 */
	@Override
	public User findUserByEmail(String mail) throws RepositoryException {
		String hql = "select u from User u where u.contactEmail = :mail "; 
		addParamToQuery("mail", mail);
		User u = null;
		try {
			u = (User)executeQueryOneResult(hql, paramsToQuery);
		}catch (Exception ne) {
			System.out.println("Não existe  > " + ne.getCause().getClass().getCanonicalName());
		}
		return u;
	}

}
