package by.itclass.controllers.user;

import by.itclass.controllers.AbstractController;
import by.itclass.model.entities.user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.itclass.constants.AppConstants.REGISTRATION_CONTROLLER;
import static by.itclass.constants.AppConstants.USER_NOT_REGISTER;
import static by.itclass.constants.JspConstants.*;

@WebServlet(name = "registrationController", urlPatterns = REGISTRATION_CONTROLLER)
public class RegistrationController extends AbstractController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(LOGIN_PARAM);
        String name = req.getParameter(NAME_PARAM);
        String password = req.getParameter(PASS_PARAM);
        String email = req.getParameter(EMAIL_PARAM);

        User user = new User(login, name, email);
        if (userService.addUser(user, password)) {
            redirect(resp, LOGIN_JSP);
        }else {
            forward(req,resp, REGISTRATION_JSP, USER_NOT_REGISTER);
        }
    }
}
