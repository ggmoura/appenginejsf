package com.wildstartech.gae.jsf2template.ioc;


import com.google.appengine.api.users.UserService;
import com.google.inject.Binder;
import com.google.inject.Module;
import com.wildstartech.gae.jsf2template.repository.UserRepository;
import com.wildstartech.gae.jsf2template.repository.UserRepositoryDAO;
import com.wildstartech.gae.jsf2template.service.UserServiceImpl;

/**
 * Define os binders para IoC
 * @author Rafael Nunes
 *
 */
public class IoCBinder implements Module {
        @SuppressWarnings("unchecked")
		public void configure(Binder binder) {
        //Service Binders
        binder.bind(UserService.class).to((Class<? extends UserService>) UserServiceImpl.class);
        
        //Repository Binders
        binder.bind(UserRepository.class).to(UserRepositoryDAO.class);
    }

}
