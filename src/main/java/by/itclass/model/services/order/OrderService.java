package by.itclass.model.services.order;

import by.itclass.model.dao.order.OrderDao;

import javax.servlet.http.HttpSession;

public class OrderService {
    private static OrderService service;
    private OrderDao orderDao;

    public OrderService() {
        orderDao = OrderDao.getInstance();
    }

    public boolean saveOrder(HttpSession session, String address) {
        return orderDao.saveOrder(session, address);
    }
}
