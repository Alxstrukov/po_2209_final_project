package by.itclass.model.dao.user;

import by.itclass.model.data_base.ConnectionManager;
import by.itclass.model.entities.user.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static by.itclass.constants.DBConstants.*;

public class UserDao {

    public User getUser(String login, String password) {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(ID_COLUMN);
                String name = resultSet.getString(NAME_COLUMN);
                String email = resultSet.getString(EMAIL_COLUMN);
                return new User(id, login, name, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addUser(User user, String password) {
        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER);
            if (isAccessible(user.getLogin())) {
                preparedStatement.setString(1, user.getLogin());
                preparedStatement.setString(2, user.getName());
                preparedStatement.setString(3, password);
                preparedStatement.setString(4, user.getEmail());
                return (preparedStatement.executeUpdate() > 0);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean isAccessible(String login) throws SQLException {
        try (Connection connection = ConnectionManager.getConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_LOGIN);
            preparedStatement.setString(1, login);
            return !preparedStatement.executeQuery().next();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
