package pl.simpleproject.api;

import pl.simpleproject.entity.User;

public interface UserRegisterLoginFacade {
    boolean registerUser (User user);
    boolean loginUser(String login, String password);
}
