package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("���", "�����", (byte) 60);
        userService.saveUser("����", "�������", (byte) 35);
        userService.saveUser("������", "���", (byte) 19);
        userService.saveUser("�����", "��������", (byte) 40);
        List<User> listsOfUsers = userService.getAllUsers();
        for (User user : listsOfUsers) {
            System.out.println(user.toString());
        }
        userService.cleanUsersTable();
        userService.dropUsersTable();
        UserDaoJDBCImpl.closeConnection();
    }
}
