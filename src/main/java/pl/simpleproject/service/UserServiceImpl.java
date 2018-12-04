package pl.simpleproject.service;

import pl.simpleproject.api.UserDao;
import pl.simpleproject.api.UserService;
import pl.simpleproject.dao.UserDaoImpl;
import pl.simpleproject.entity.User;
import pl.simpleproject.exception.UserLoginAlreadyExistException;
import pl.simpleproject.validator.UserValidator;

import java.io.IOException;
import java.util.List;

public class UserServiceImpl implements UserService {

    // singleton
    private static UserServiceImpl instance = null;

    private UserServiceImpl() {
    }

    public static UserServiceImpl getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }

    // objects
    UserDao userDao = UserDaoImpl.getInstance();
    UserValidator userValidator = UserValidator.getInstance();

    @Override
    public List<User> getAllUsers() throws IOException {
        return userDao.getAllUsers();
    }

    @Override
    public boolean addUser(User user) {
        try {
            if (isLoginAlreadyExist(user.getLogin())) {
                throw new UserLoginAlreadyExistException();
            }

            if (userValidator.isValidate(user)) {
                userDao.saveUser(user);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void removeUserById(Long userId) throws IOException {
        userDao.removeUserById(userId);
    }

    private boolean isLoginAlreadyExist(String login) {
        User user = getUserByLogin(login);
        return user != null;
    }

    @Override
    public User getUserById(Long userId) {
        List<User> users = null;
        try {
            users = getAllUsers();
            for (User user : users) {
                boolean userFound = user.getUserId().equals(userId);
                if (userFound) {
                    return user;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUserByLogin(String login) {
        List<User> users = null;
        try {
            users = getAllUsers();
            for (User user : users) {
                boolean userFound = user.getLogin().equals(login);
                if (userFound) {
                    return user;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean isCorrectLoginAndPassword(String login, String password) {
        User foundUser = getUserByLogin(login);
        if (foundUser == null) {
            return false;
        }
        boolean loginMatch = foundUser.getLogin().equals(login);
        boolean passwordMatch = foundUser.getPassword().equals(password);

        return loginMatch && passwordMatch;
    }
}
