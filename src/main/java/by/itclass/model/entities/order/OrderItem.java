package by.itclass.model.entities.order;

import by.itclass.model.entities.food.FoodItem;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
@EqualsAndHashCode
public class OrderItem {
    private String orderId;
    private final FoodItem foodItem;
    private final int quantity;
}
