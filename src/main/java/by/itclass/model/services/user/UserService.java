package by.itclass.model.services.user;

import by.itclass.model.dao.user.UserDao;
import by.itclass.model.entities.user.User;
import by.itclass.model.services.IService;

public class UserService implements IService {
    private UserDao dao;

    public UserService() {
        dao = new UserDao();
    }

    public User getUser(String login, String password) {
        return dao.getUser(login, password);
    }

    public boolean addUser(User user, String password) {
        return dao.addUser(user, password);
    }
}