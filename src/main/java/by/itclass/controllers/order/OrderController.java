package by.itclass.controllers.order;

import by.itclass.controllers.abstraction.AbstractController;
import by.itclass.controllers.abstraction.OrderAbstractController;
import by.itclass.model.entities.order.Order;
import by.itclass.model.services.order.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static by.itclass.constants.AppConstants.ORDER_CONTROLLER;
import static by.itclass.constants.JspConstants.*;

@WebServlet(name = "orderController", urlPatterns = ORDER_CONTROLLER)
public class OrderController extends OrderAbstractController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String address = req.getParameter(ADDRESS_PARAM);
        HttpSession session = req.getSession();

        if (orderService.saveOrder(session, address)) {
            String orderId = (String) session.getAttribute("orderId");
            session.removeAttribute(ORDER_ITEMS_ATTRIBUTE);
            session.removeAttribute(ORDER_ID_ATTRIBUTE);
            forward(req, resp, HOME_JSP, "Your order number is "
                    + orderId + ". You can se it on Orders page...");
        } else {
            forward(req, resp, CART_JSP, "Smth went wrong...");
        }

    }
}
