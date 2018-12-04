package pl.simpleproject.entity;

import pl.simpleproject.entity.enumtype.Separators;

import java.util.Objects;

public class User {

    private Long userId;
    private String login;
    private String password;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(long userId, String login, String password) {
        setUserId(userId);
        setLogin(login);
        setPassword(password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getUserId(), user.getUserId()) &&
                Objects.equals(getLogin(), user.getLogin()) &&
                Objects.equals(getPassword(), user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getLogin(), getPassword());
    }

    @Override
    public String toString() {
        return userId + Separators.SEPARATOR.toString() + login + Separators.SEPARATOR.toString() + password;
    }
}