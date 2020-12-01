package app.dao;

import app.beans.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private String USER_SELECT = "SELECT * FROM users WHERE users.role = 'enrol' and users.name = ? and users.password = ?;";
    private String USER_INSERT = "INSERT users (role, name, password) VALUES ('enrol', ?, ?);";

    public UserDAO(){}

    public User getUser(String name, String password) {
        User user = null;
        try (Connection connection = ConnectionPool.getInstance().connect()){
            PreparedStatement preparedStatement = connection.prepareStatement(USER_SELECT);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                return null;
            }
            user = new User(resultSet.getString("name"),resultSet.getString("password"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    public User registerUser(User user) {
        try (Connection connection = ConnectionPool.getInstance().connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(USER_INSERT);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getUser(user.getName(), user.getPassword());
    }
}
