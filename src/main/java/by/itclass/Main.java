package by.itclass;

import by.itclass.model.data_base.ConnectionManager;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            ConnectionManager.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
