package by.itclass.model.entities.order;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Order {
    private String id;
    private String date;
    private String address;
}
