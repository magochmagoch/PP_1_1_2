package jm.task.core.jdbc;

import com.mysql.cj.jdbc.NonRegisteringDriver;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final UserServiceImpl usi = new UserServiceImpl();
        usi.createUsersTable();
        usi.saveUser("Сан", "Саныч", (byte) 60);
        usi.saveUser("Макс", "Штирлиц", (byte) 35);
        usi.saveUser("Иоганн", "Бах", (byte) 19);
        usi.saveUser("Жорик", "Вартанов", (byte) 40);
        List<User> listsOfUsers = usi.getAllUsers();
        for (User user : listsOfUsers) {
            System.out.println(user.toString());
        }
        usi.cleanUsersTable();
        usi.dropUsersTable();
    }
}
