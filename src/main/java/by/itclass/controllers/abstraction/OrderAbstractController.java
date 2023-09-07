package by.itclass.controllers.abstraction;

import by.itclass.model.services.ServiceFactory;
import by.itclass.model.services.ServiceType;
import by.itclass.model.services.order.OrderService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "orderAbstractController")
public abstract class OrderAbstractController extends AbstractController {
    protected OrderService orderService;

    @Override
    public void init() throws ServletException {
        orderService = (OrderService) ServiceFactory.getInstance(ServiceType.ORDER_SERVICE);
    }
}
