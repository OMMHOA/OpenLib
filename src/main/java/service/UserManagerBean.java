package service;

import dal.UserFacade;
import entity.Book;
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
        User existingUser = getUser(user);
        return existingUser != null;
    }

    public boolean isAuthCorrect(User user) {
        User existingUser = getUser(user);
        return existingUser != null && existingUser.getPassword().equals(user.getPassword());
    }

    private User getUser(User user) {
        return userFacade.find(user.getUsername());
    }

}
