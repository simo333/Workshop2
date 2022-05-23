package pl.coderslab;

import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDAO;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        User newUser = new User();
        newUser.setUserName("szymon");
        newUser.setEmail("szymon@mail.com");
        newUser.setPassword("haslo");

        User newUser2 = new User();
        newUser2.setUserName("szymon");
        newUser2.setEmail("szymon@mail2.com");
        newUser2.setPassword("haslo");

        User nonExistingUser = new User();
        nonExistingUser.setId(100000);

        User nullUser = null;

        User userToUpdateCorrect = new User();
        userToUpdateCorrect.setId(1);
        userToUpdateCorrect.setUserName("update");
        userToUpdateCorrect.setEmail("szymon_updated@mail.com");
        userToUpdateCorrect.setPassword("haslo");

        User userToUpdateDuplicateEmail = new User();
        userToUpdateDuplicateEmail.setId(2);
        userToUpdateDuplicateEmail.setUserName("update2");
        userToUpdateDuplicateEmail.setEmail("szymon_updated@mail.com");
        userToUpdateDuplicateEmail.setPassword("haslo");

        //Testing create method
        System.out.println("CREATE method:");
        createUser(newUser);
        createUser(newUser2);

        //Testing read method
        System.out.println("READ method:");
        readUser(newUser.getId());        //User obj
        readUser(nonExistingUser.getId());    //null

        //Testing update method
        System.out.println("UPDATE method:");
        updateUser(userToUpdateCorrect);            //Correct update
        updateUser(userToUpdateDuplicateEmail);     //Unable to update duplicated email
        updateUser(nonExistingUser);                //Updating user non-existing in db
        updateUser(nullUser);                       //Updating null value

        //Testing delete method
        System.out.println("DELETE method:");
        deleteUser(newUser.getId());    //Deleting existing user
        readUser(newUser.getId());      //Expect null
        deleteUser(nonExistingUser.getId());   //Deleting non-existing user

        //Testing findAll method
        System.out.println("FINDALL method:");
        findAllUser();
    }

    static void createUser(User user) {
        UserDAO userDAO = new UserDAO();
        System.out.println(userDAO.create(user));
    }

    static void readUser(int id) {
        UserDAO userDAO = new UserDAO();
        System.out.println(userDAO.read(id));
    }

    static void updateUser(User user) {
        UserDAO userDAO = new UserDAO();
        userDAO.update(user);
    }

    static void deleteUser(int id) {
        UserDAO userDAO = new UserDAO();
        userDAO.delete(id);
    }

    static void findAllUser() {
        UserDAO userDAO = new UserDAO();
        System.out.println(Arrays.toString(userDAO.findAll()));
    }

}
