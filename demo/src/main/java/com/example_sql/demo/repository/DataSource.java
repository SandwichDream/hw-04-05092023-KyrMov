package com.example_sql.demo.repository;

import java.sql.Connection;
import java.sql.SQLException;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DataSource {

    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    static {
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/dev");
        config.setUsername("postgres");
        config.setPassword("1379");
        ds = new HikariDataSource(config);
    }

    public static Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("Помилка при отриманні підключення до бази даних.", e);
        }
    }

    private DataSource() {
    }
}