package by.itclass.model.services;

import by.itclass.model.services.food.FoodService;
import by.itclass.model.services.order.CartService;
import by.itclass.model.services.order.OrderService;
import by.itclass.model.services.user.UserService;

import java.util.HashMap;
import java.util.Map;

public class ServiceFactory {
    private static Map<ServiceType, IService> services;

    public static void init() {
        services = new HashMap<>();
        services.put(ServiceType.USER_SERVICE, new UserService());
        services.put(ServiceType.FOOD_SERVICE, new FoodService());
        services.put(ServiceType.CART_SERVICE, new CartService());
        services.put(ServiceType.ORDER_SERVICE, new OrderService());
    }

    public static IService getInstance(ServiceType type) {
        return services.get(type);
    }
}
