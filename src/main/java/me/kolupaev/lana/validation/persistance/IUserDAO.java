package me.kolupaev.lana.validation.persistance;

import me.kolupaev.lana.validation.business.User;
import me.kolupaev.lana.validation.controller.UserAlreadyExistsException;

/**
 * @author Lana Kolupaev
 * @date 2015-05-18
 */
public interface IUserDAO {
    void register(User user) throws UserAlreadyExistsException;
    boolean isUsernameAvailable(String username);
}
