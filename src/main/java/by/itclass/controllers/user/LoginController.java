package by.itclass.controllers.user;

import by.itclass.controllers.abstraction.AbstractController;
import by.itclass.controllers.abstraction.UserAbstractController;
import by.itclass.model.entities.user.User;
import by.itclass.model.services.user.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static by.itclass.constants.AppConstants.LOGIN_CONTROLLER;
import static by.itclass.constants.AppConstants.USER_NOT_FOUND;
import static by.itclass.constants.JspConstants.*;

@WebServlet(name = "loginController", urlPatterns = LOGIN_CONTROLLER)
public class LoginController extends UserAbstractController {//наследуемся (extends) от нами созданного абстрактного класса

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(LOGIN_PARAM);//имя кнопки инпут откуда потом буду ловить значение
        String password = req.getParameter(PASS_PARAM);//имя кнопки инпут откуда потом буду ловить значение

        User user = userService.getUser(login, password);
        if (user != null) {
            final HttpSession session = req.getSession();//получаем сессию
            // (она нужна чтобы данные введенные на сервере хранились хотя бы полчаса (по умолчанию))
            session.setAttribute(USER_ATTRIBUTE, user);
            forward(req, resp, HOME_JSP);//перенаправляем на другую страницу
        } else {
            forward(req, resp, LOGIN_JSP, USER_NOT_FOUND);
        }
    }
}
