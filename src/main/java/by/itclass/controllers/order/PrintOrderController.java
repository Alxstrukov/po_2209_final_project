package by.itclass.controllers.order;

import by.itclass.controllers.abstraction.AbstractController;
import by.itclass.controllers.abstraction.OrderAbstractController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static by.itclass.constants.AppConstants.PRINT_ORDER_CONTROLLER;
import static by.itclass.constants.JspConstants.*;

@WebServlet(name = "printOrderController", urlPatterns = PRINT_ORDER_CONTROLLER)
public class PrintOrderController extends OrderAbstractController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter(ORDER_ID_ATTRIBUTE);
        String receipt = orderService.buildReceipt(orderId);
        req.setAttribute(ORDERS_RECEIPT_ATTRIBUTE, receipt);
        forward(req, resp, RECEIPT_JSP);
    }
}
