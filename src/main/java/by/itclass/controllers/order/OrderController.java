package by.itclass.controllers.order;

import by.itclass.controllers.AbstractController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static by.itclass.constants.AppConstants.ORDER_CONTROLLER;
import static by.itclass.constants.JspConstants.ADDRESS_PARAM;

@WebServlet (name = "orderController", urlPatterns = ORDER_CONTROLLER)
public class OrderController extends AbstractController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String address = req.getParameter(ADDRESS_PARAM);
        HttpSession session = req.getSession();


    }
}
