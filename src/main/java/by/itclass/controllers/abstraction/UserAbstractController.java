package by.itclass.controllers.abstraction;

import by.itclass.model.services.ServiceFactory;
import by.itclass.model.services.ServiceType;
import by.itclass.model.services.user.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet (name = "userAbstractController")
public class UserAbstractController extends AbstractController{
    protected UserService userService;

    @Override
    public void init() throws ServletException {
        userService = (UserService) ServiceFactory.getInstance(ServiceType.USER_SERVICE);
    }
}
