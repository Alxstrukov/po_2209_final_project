package by.itclass.model.services.order;

import by.itclass.model.entities.order.OrderItem;
import by.itclass.model.services.IService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static by.itclass.constants.JspConstants.ORDER_ITEMS_ATTRIBUTE;

public class CartService implements IService {

    public List<OrderItem> processCart(HttpSession session, String cartAction, OrderItem item) {
        List<OrderItem> items = session.getAttribute(ORDER_ITEMS_ATTRIBUTE) != null
                ? (List<OrderItem>) session.getAttribute(ORDER_ITEMS_ATTRIBUTE)
                : new ArrayList<>();
        switch (cartAction) {
            case "addToCart": {
                items.add(item);
            }
            break;
            case "removeFromCart": {
                items.remove(item);
            }
            break;
            default: {

            }
            break;
        }
        return items;
    }
}
