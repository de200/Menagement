package pl.simpleproject.facade;

import pl.simpleproject.api.UserRegisterLoginFacade;
import pl.simpleproject.api.UserService;
import pl.simpleproject.entity.User;
import pl.simpleproject.service.UserServiceImpl;

public class UserRegisterLoginFacadeImpl implements UserRegisterLoginFacade {

    // singleton
    private UserService userService = UserServiceImpl.getInstance();
    private static UserRegisterLoginFacadeImpl instance = null;

    private UserRegisterLoginFacadeImpl() {
    }


    public static UserRegisterLoginFacadeImpl getInstance() {
        if (instance == null) {
            instance = new UserRegisterLoginFacadeImpl();
        }
        return instance;
    }

    @Override
    public boolean registerUser(User user) {
        return userService.addUser(user);
    }

    @Override
    public boolean loginUser(String login, String password) {
        if (userService.isCorrectLoginAndPassword(login, password)) {
            return true;
        }
        return false;
    }
}
