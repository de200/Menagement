package pl.simpleproject.dao;

import pl.simpleproject.Utils.FileUtils;
import pl.simpleproject.api.UserDao;
import pl.simpleproject.entity.User;
import pl.simpleproject.entity.parser.UserParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private static final String fileName = "users.data";

    // singleton
    private UserDaoImpl() {
        try {
            FileUtils.createNewFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static UserDaoImpl instance = null;

    public static UserDaoImpl getInstance(){
        if(instance == null ){
            instance = new UserDaoImpl();
        }
        return instance;
    }

    public void saveUser(User user) throws IOException {
        List<User> users = getAllUsers();
        users.add(user);
        saveUsers(users);
    }

    public void saveUsers(List<User> users) throws IOException {
        FileUtils.createNewFile(fileName);
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(fileName, true));
        for (User user : users) {
            printWriter.write(user.toString() + "\n");
        }
        printWriter.close();

    }

    public List<User> getAllUsers() throws IOException {
        List<User> users = new ArrayList<User>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String readLine = reader.readLine();
        while (readLine != null) {
            User user = UserParser.convertToUser(readLine);
            if (user != null) {
                users.add(user);
            }
            readLine = reader.readLine();
        }
        reader.close();
        return users;
    }

    public User getUserByLogin(String login) throws IOException {
        List<User> users = getAllUsers();
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    public User getUserById(Long userId) throws IOException {
        List<User> users = getAllUsers();
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    public void removeUserByLogin(String login) throws IOException {
        List<User> users = getAllUsers();
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                users.remove(user);
            }
        }
        saveUsers(users);

    }

    public void removeUserById(Long userId) throws IOException {
        List<User> users = getAllUsers();
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                users.remove(user);
            }
        }
        saveUsers(users);
    }
}
