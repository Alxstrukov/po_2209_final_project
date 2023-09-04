package by.itclass.model.dao.order;

import by.itclass.model.data_base.ConnectionManager;
import by.itclass.model.entities.order.OrderItem;
import by.itclass.model.entities.user.User;
import jdk.vm.ci.meta.Local;

import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static by.itclass.constants.DBConstants.INSERT_ORDER;
import static by.itclass.constants.JspConstants.ORDER_ITEMS_ATTRIBUTE;
import static by.itclass.constants.JspConstants.USER_ATTRIBUTE;

public class OrderDao {
    private static OrderDao dao;

    public OrderDao() {
        ConnectionManager.init();
    }

    public static OrderDao getInstance() {
        return dao == null
                ? new OrderDao()
                : dao;
    }

    public boolean saveOrder(HttpSession session, String address) {
        User user = (User) session.getAttribute(USER_ATTRIBUTE);
        LocalDateTime now = LocalDateTime.now();//взять настоящее время
        String date = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String time = now.format(DateTimeFormatter.ofPattern("HH-mm"));
        String orderId = user.getName() + "_" + date + "_" + time;

        List<OrderItem> items = (List<OrderItem>) session.getAttribute(ORDER_ITEMS_ATTRIBUTE);
        saveOrder(orderId, date, user.getId(), address);

    }

    private boolean saveOrder(String orderId, String date, int userId, String address) {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDER)) {
            preparedStatement.setString(1, orderId);
            preparedStatement.setString(2, date);
            preparedStatement.setInt(3, userId);
            preparedStatement.setString(4, address);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
