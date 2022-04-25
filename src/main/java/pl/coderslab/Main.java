package pl.coderslab;

import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDAO;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setUserName("szymon");
        user.setEmail("szymon@mail.com1");
        user.setPassword("haslo");

        //Testing create method
        createUser(user);

        //Testing read method
        readUser(1);        //User obj
        readUser(10000);    //null
    }

    static void createUser(User user) {
        UserDAO userDAO = new UserDAO();
        System.out.println(userDAO.create(user));
    }

    static void readUser(int id) {
        UserDAO userDAO = new UserDAO();
        System.out.println(userDAO.read(id));
    }
}
