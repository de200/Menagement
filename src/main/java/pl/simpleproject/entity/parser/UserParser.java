package pl.simpleproject.entity.parser;

import pl.simpleproject.entity.enumtype.Separators;
import pl.simpleproject.entity.User;

public class UserParser {

    public static User convertToUser(String readLine){
        String[] userInformation = readLine.split(Separators.SEPARATOR.toString());
        Long userId = Long.parseLong(userInformation[0]);
        String login = userInformation[1];
        String password = userInformation[2];

        return new User(userId, login, password);
    }
}
