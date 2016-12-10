package service;

import dal.UserFacade;
import entity.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class UserManagerBean {

    @EJB
    private UserFacade userFacade;

    public void createUser(User user) {
        userFacade.create(user);
    }

    public boolean isUserAlreadyExists(User user) {
        User existingUser = userFacade.find(user.getUsername());
        return existingUser != null;
    }
}
