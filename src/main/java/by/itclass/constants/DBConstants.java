package by.itclass.constants;

public class DBConstants {
    public static final String ID_COLUMN = "id";
    public static final String DATE_COLUMN = "date";
    public static final String ADDRESS_COLUMN = "address";
    public static final String LOGIN_COLUMN = "login";
    public static final String NAME_COLUMN = "name";
    public static final String PASSWORD_COLUMN = "password";
    public static final String EMAIL_COLUMN = "email";
    public static final String PRICE_COLUMN = "price";
    public static final String QUANTITY_COLUMN = "quantity";
    public static final String AMOUNT_COLUMN = "amount";

    public static final String SELECT_USER = "SELECT id, name, email FROM user WHERE login = ? AND password = ?";
    public static final String INSERT_USER = "INSERT INTO user (login, name, password, email) VALUES (?, ?, ?, ?)";
    public static final String SELECT_USER_BY_LOGIN = "SELECT id FROM user WHERE login = ?";
    public static final String SELECT_FOOD_BY_TYPE = "SELECT id, name, price FROM foodItem WHERE foodTypeId = ?";

    public static final String INSERT_ORDER = "INSERT INTO orders (id, date, userId, address) VALUES (?, ?, ?, ?)";
    public static final String INSERT_ORDER_ITEM = "INSERT INTO orderItem (orderId, itemId, quantity) VALUES (?, ?, ?)";
    public static final String SELECT_ORDERS_BY_USER = "SELECT id, date, address FROM orders WHERE userId = ? ORDER BY id DESC";
    public static final String SELECT_HEAD_ORDER = "SELECT date, address FROM orders WHERE id = ?";
    public static final String SELECT_ITEMS_FOR_ORDER = "SELECT f.name AS name, f.price AS price, o.quantity AS quantity, (price * quantity) AS amount " +
            "FROM foodItem f INNER JOIN orderItem o ON f.id = o.itemId " +
            "WHERE o.orderId = ?";
    public static final String SELECT_TOTAL_AMOUNT = "SELECT SUM(amount) as amount FROM (" + SELECT_ITEMS_FOR_ORDER + ") t";
}
