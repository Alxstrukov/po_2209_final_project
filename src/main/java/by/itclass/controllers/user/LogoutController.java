package by.itclass.controllers.user;

import by.itclass.controllers.abstraction.AbstractController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.itclass.constants.AppConstants.LOGOUT_CONTROLLER;
import static by.itclass.constants.JspConstants.INDEX_JSP;

@WebServlet(name = "logoutController", urlPatterns = LOGOUT_CONTROLLER)
public class LogoutController extends AbstractController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final HttpSession SESSION = req.getSession();
        SESSION.invalidate();
        redirect(resp, INDEX_JSP);
    }
}
