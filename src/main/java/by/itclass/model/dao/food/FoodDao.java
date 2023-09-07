package by.itclass.model.dao.food;

import by.itclass.model.data_base.ConnectionManager;
import by.itclass.model.entities.food.FoodItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.itclass.constants.DBConstants.*;

public class FoodDao {

    public List<FoodItem> getFoodByType(int foodType) {
        List<FoodItem> items = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FOOD_BY_TYPE)) {
            preparedStatement.setInt(1, foodType);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(ID_COLUMN);
                String name = resultSet.getString(NAME_COLUMN);
                double price = resultSet.getDouble(PRICE_COLUMN);
                items.add(new FoodItem(id, foodType, name, price));
            }
        } catch (SQLException exception) {

        }
        return items;
    }
}
