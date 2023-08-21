package by.itclass.model.dao.user;

import by.itclass.model.data_base.ConnectionManager;
import by.itclass.model.entities.user.User;

public class UserDao {
    private static UserDao dao;

    public UserDao() {
        ConnectionManager.init();
    }

    public static UserDao getInstance() {
        return dao == null ? new UserDao() : dao;//создаем подключение к БД и сразу объект dao
    }

    public User getUser(String login, String password) {
        return null;//заглушка
    }

    public boolean addUser(User user, String password) {
        return true;//заглушка
    }
}
