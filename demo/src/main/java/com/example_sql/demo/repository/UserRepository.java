package com.example_sql.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example_sql.demo.model.User;
import com.example_sql.demo.model.UserRole;

@Repository
public class UserRepository {

    private static final String INSERT_QUERY = "insert into users(name, role_id) values(?, ?);";
    private static final String UPDATE_QUERY = "UPDATE users SET name = ?, role_id = ? WHERE id = ?;";
    private static final String DELETE_QUERY = "DELETE FROM users WHERE id = ?;";
    private static final String SELECT_QUERY = "select * from users;";
    private static final String SELECT_name_QUERY = "select * from users where name = ? order by id;";
    private static final String SELECT_with_roles_QUERY = "SELECT u.id, u.name, r.name from users u JOIN roles r on u.role_id = r.id order by r.id, u.name;";

    public boolean add(User user) {
        var connection = DataSource.getConnection();
        try (var statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setString(1, user.getName());
            statement.setInt(2, user.getRoleID());
            statement.execute();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(User user) {
        var connection = DataSource.getConnection();
        try (var statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, user.getName());
            statement.setInt(2, user.getRoleID());
            statement.setInt(3, user.getID());
            statement.execute();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean remove(int id) {
        var connection = DataSource.getConnection();
        try (var statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, id);
            statement.execute();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAll() {
        var connection = DataSource.getConnection();
        try (var set = connection.prepareStatement(SELECT_QUERY).executeQuery()) {
            var users = new ArrayList<User>();
            while (set.next()) {
                users.add(new User(set.getInt(1), set.getString(2), set.getInt(3)));
            }
            return users;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAll(String name) {
        var connection = DataSource.getConnection();
        try (var statement = connection.prepareStatement(SELECT_name_QUERY)) {
            statement.setString(1, name);
            statement.execute();
            try (var set = statement.executeQuery()) {
                var users = new ArrayList<User>();
                while (set.next()) {
                    users.add(new User(set.getInt(1), set.getString(2), set.getInt(3)));
                }
                return users;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<UserRole> getAllWithRole() {
        var connection = DataSource.getConnection();
        try (var set = connection.prepareStatement(SELECT_with_roles_QUERY).executeQuery()) {
            var users = new ArrayList<UserRole>();
            while (set.next()) {
                users.add(new UserRole(set.getInt(1), set.getString(2), set.getString(3)));
            }
            return users;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}