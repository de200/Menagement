package pl.simpleproject.validator;


import pl.simpleproject.entity.User;
import pl.simpleproject.exception.UserLoginAlreadyExistException;
import pl.simpleproject.exception.UserShortLengthLoginException;
import pl.simpleproject.exception.UserShortLengthPasswordException;



public class UserValidator {

    public final int MIN_PASSWORD_LENGTH = 6;
    public final int MIN_LOGIN_LENGTH = 4;

    // singleton
    private UserValidator() {
    }

    private static UserValidator instance = null;

    public static UserValidator getInstance() {
        if (instance == null) {
            instance = new UserValidator();
        }
        return instance;
    }


    // methods
    public boolean isValidate(User user) throws UserShortLengthPasswordException, UserShortLengthLoginException, UserLoginAlreadyExistException {
        if (!isPasswordLengthEnough(user.getPassword())) {
            throw new UserShortLengthPasswordException("Password is too short. Min 6 characters");
        }
        if (!isLoginLengthEnough(user.getLogin())) {
            throw new UserShortLengthLoginException("Login is too short. Min 4 characters");
        }

        return true;
    }

    private boolean isPasswordLengthEnough(String password) {
        return password.length() >= MIN_PASSWORD_LENGTH;
    }

    private boolean isLoginLengthEnough(String login) {
        return login.length() >= MIN_LOGIN_LENGTH;
    }


}
