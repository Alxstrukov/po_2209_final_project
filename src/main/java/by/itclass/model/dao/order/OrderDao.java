package by.itclass.model.dao.order;

import by.itclass.model.data_base.ConnectionManager;
import by.itclass.model.entities.order.Order;
import by.itclass.model.entities.order.OrderItem;
import by.itclass.model.entities.user.User;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static by.itclass.constants.DBConstants.*;
import static by.itclass.constants.JspConstants.*;

public class OrderDao {

    public boolean saveOrder(HttpSession session, String address) {
        User user = (User) session.getAttribute(USER_ATTRIBUTE);
        LocalDateTime now = LocalDateTime.now();//взять настоящее время
        String date = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String time = now.format(DateTimeFormatter.ofPattern("HH-mm"));
        String orderId = user.getName() + "_" + date + "_" + time;

        List<OrderItem> items = (List<OrderItem>) session.getAttribute(ORDER_ITEMS_ATTRIBUTE);
        boolean success = true;
        if (saveOrder(orderId, date, user.getId(), address)) {
            for (OrderItem item : items) {
                boolean isSaved = saveOrderItem(orderId, item);
                if (!isSaved) {
                    success = false;
                }
            }
        } else {
            return false;
        }
        if (success) session.setAttribute(ORDER_ID_ATTRIBUTE, orderId);

        return success;
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
        return false;
    }

    private boolean saveOrderItem(String orderId, OrderItem orderItem) {
        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDER_ITEM);
            preparedStatement.setString(1, orderId);
            preparedStatement.setInt(2, orderItem.getFoodItem().getId());
            preparedStatement.setInt(3, orderItem.getQuantity());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Order> getOrders(int userId) {
        List<Order> orders = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDERS_BY_USER)) {
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString(ID_COLUMN);
                String date = resultSet.getString(DATE_COLUMN);
                String address = resultSet.getString(ADDRESS_COLUMN);
                orders.add(new Order(id, date, address));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public String buildReceipt(String orderId) {
        StringBuilder stringBuilder = new StringBuilder();
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_HEAD_ORDER)) {
            preparedStatement.setString(1, orderId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String date = resultSet.getString(DATE_COLUMN);
                String address = resultSet.getString(ADDRESS_COLUMN);
                stringBuilder
                        .append("<h2> Order id: ")
                        .append(orderId)
                        .append("</h2>")
                        .append("<h2> Date of order: ")
                        .append(date)
                        .append("</h2>")
                        .append("<h2> Delivery address: ")
                        .append(address)
                        .append("</h2>")
                        .append("<h2 class = underLine> You ordered: </h2>")
                        .append(getItems(orderId))
                        .append(getTotalAmount(orderId));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    private String getItems(String orderId) {
        StringBuilder stringBuilder = new StringBuilder();
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ITEMS_FOR_ORDER)) {
            preparedStatement.setString(1, orderId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                stringBuilder.append("<h2>").append(resultSet.getInt(QUANTITY_COLUMN)).append(" ")
                        .append(resultSet.getString(NAME_COLUMN)).append(" ")
                        .append(resultSet.getDouble(PRICE_COLUMN))
                        .append(" BYN. Amount: ").append(resultSet.getDouble(AMOUNT_COLUMN)).append(" BYN. </h2>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    private String getTotalAmount(String orderId) {
        StringBuilder stringBuilder = new StringBuilder();
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TOTAL_AMOUNT)) {
            preparedStatement.setString(1, orderId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                stringBuilder.append("<h2 class='underline'> Total amount: ")
                        .append(resultSet.getDouble(AMOUNT_COLUMN)).append(" BYN. </h2>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
