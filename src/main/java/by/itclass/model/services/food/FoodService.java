package by.itclass.model.services.food;

import by.itclass.model.dao.food.FoodDao;
import by.itclass.model.entities.food.FoodItem;
import by.itclass.model.services.IService;

import java.util.List;

public class FoodService implements IService {
    private FoodDao dao;

    public FoodService() {
        dao = new FoodDao();
    }

    public List<FoodItem> getFoodByType(int foodType) {
        return dao.getFoodByType(foodType);
    }
}
