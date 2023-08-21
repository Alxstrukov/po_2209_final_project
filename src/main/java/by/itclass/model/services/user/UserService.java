package by.itclass.model.services.user;

import by.itclass.model.dao.user.UserDao;
import by.itclass.model.entities.user.User;

public class UserService {
    private static UserService service;
    private UserDao dao;

    public UserService() {
        dao = UserDao.getInstance();//создаем объект dao или же получаем его если он уже есть(был создан заранее)
    }

    public static UserService getInstance() {
        return service == null ? new UserService() : service;
    }

    public User getUser(String login, String password) {
        return dao.getUser(login, password);
    }

    public boolean addUser(User user, String password) {
        return dao.addUser(user, password);
    }
}