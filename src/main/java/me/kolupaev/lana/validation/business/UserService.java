package me.kolupaev.lana.validation.business;

import me.kolupaev.lana.validation.controller.UserAlreadyExistsException;
import me.kolupaev.lana.validation.persistance.IUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author Lana Kolupaev
 * @date 2015-05-18
 */
@Controller
public class UserService {
    @Autowired
    private IUserDAO dao;

    public void register(User user) throws UserAlreadyExistsException {
        dao.register(user);
    }

    public boolean validateUsername (String username) {
        return dao.isUsernameAvailable(username);
    }

}
