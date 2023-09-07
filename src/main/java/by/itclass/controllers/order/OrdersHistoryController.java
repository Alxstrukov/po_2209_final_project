package by.itclass.controllers.order;

import by.itclass.controllers.abstraction.AbstractController;
import by.itclass.controllers.abstraction.OrderAbstractController;
import by.itclass.model.entities.order.Order;
import by.itclass.model.entities.user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import static by.itclass.constants.AppConstants.ORDERS_HISTORY_CONTROLLER;
import static by.itclass.constants.JspConstants.*;

@WebServlet(name = "ordersHistoryController", urlPatterns = ORDERS_HISTORY_CONTROLLER)
public class OrdersHistoryController extends OrderAbstractController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int userId = ((User) session.getAttribute(USER_ATTRIBUTE)).getId();
        List<Order> orders = orderService.getOrders(userId);

        req.setAttribute(ORDERS_ATTRIBUTE, orders);

        forward(req, resp, ORDERS_JSP);
    }
}
