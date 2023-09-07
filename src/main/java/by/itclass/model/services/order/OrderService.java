package by.itclass.model.services.order;

import by.itclass.model.dao.order.OrderDao;
import by.itclass.model.entities.order.Order;
import by.itclass.model.services.IService;

import javax.servlet.http.HttpSession;
import java.util.List;

public class OrderService implements IService {
    private OrderDao orderDao;

    public OrderService() {
        orderDao = new OrderDao();
    }

    public boolean saveOrder(HttpSession session, String address) {
        return orderDao.saveOrder(session, address);
    }

    public List<Order> getOrders(int userId) {
        return orderDao.getOrders(userId);
    }

    public String buildReceipt(String orderId){
        return orderDao.buildReceipt(orderId);
    }
}
