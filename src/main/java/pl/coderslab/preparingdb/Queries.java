package pl.coderslab.preparingdb;

public class Queries {
    public final static String queryCreateTableUsers = "create table users (" +
            "  id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT, " +
            "  email VARCHAR(255) NOT NULL UNIQUE, " +
            "  username VARCHAR(255) NOT NULL, " +
            "  password VARCHAR(60) NOT NULL" +
            ")";
}
