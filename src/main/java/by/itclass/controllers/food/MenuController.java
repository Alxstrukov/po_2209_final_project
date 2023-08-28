package by.itclass.controllers.food;

import by.itclass.controllers.AbstractController;
import by.itclass.model.entities.food.FoodItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import static by.itclass.constants.AppConstants.MENU_CONTROLLER;
import static by.itclass.constants.JspConstants.*;

@WebServlet(name = "menuController", urlPatterns = MENU_CONTROLLER)
public class MenuController extends AbstractController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int foodType = Integer.parseInt(req.getParameter(FOOD_TYPE_PARAM));

        List<FoodItem> items = foodService.getFoodByType(foodType);

        richRequest(req, foodType, items);
        forward(req, resp, HOME_JSP);
    }

    private void richRequest(HttpServletRequest req, int foodType, List<FoodItem> items) {
        switch (foodType) {
            case 1: {
                req.setAttribute(PIZZAS_ATTRIBUTE, items);
                break;
            }

            case 2: {
                req.setAttribute(DRINKS_ATTRIBUTE, items);
                break;
            }
            default:
                break;

        }
    }
}
