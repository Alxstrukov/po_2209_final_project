package by.itclass.controllers;

import by.itclass.model.services.food.FoodService;
import by.itclass.model.services.order.CartService;
import by.itclass.model.services.user.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.itclass.constants.JspConstants.MESSAGE_ATTRIBUTE;

public abstract class AbstractController extends HttpServlet {
    protected UserService userService;
    protected FoodService foodService;
    protected CartService cartService;

    @Override
    public void init() throws ServletException {
        userService = UserService.getInstance();
        foodService = FoodService.getInstance();
        cartService = CartService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void forward(HttpServletRequest req, HttpServletResponse resp, String url)
            throws ServletException, IOException {
        req.getRequestDispatcher(url).forward(req, resp);
    }

    protected void forward(HttpServletRequest req, HttpServletResponse resp, String url, String message)
            throws ServletException, IOException {
        req.setAttribute(MESSAGE_ATTRIBUTE, message);
        forward(req, resp, url);
    }

    protected void redirect(HttpServletResponse resp, String url) throws ServletException, IOException {
        resp.sendRedirect(getServletContext().getContextPath() + url);

    }


}
