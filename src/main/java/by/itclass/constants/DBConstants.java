package by.itclass.constants;

public class DBConstants {
    public static final String ID_COLUMN = "id";
    public static final String LOGIN_COLUMN = "login";
    public static final String NAME_COLUMN = "name";
    public static final String PASSWORD_COLUMN = "password";
    public static final String EMAIL_COLUMN = "email";
    public static final String PRICE_COLUMN = "price";

    public static final String SELECT_USER = "SELECT id, name, email FROM user WHERE login = ? AND password = ?";
    public static final String INSERT_USER = "INSERT INTO user (login, name, password, email) VALUES (?, ?, ?, ?)";
    public static final String SELECT_USER_BY_LOGIN = "SELECT id FROM user WHERE login = ?";
    public static final String SELECT_FOOD_BY_TYPE = "SELECT id, name, price FROM foodItem WHERE foodTypeId = ?";

    public static final String INSERT_ORDER = "INSERT INTO orders (id, date, userId, address) VALUES (?, ?, ?, ?)";
}
