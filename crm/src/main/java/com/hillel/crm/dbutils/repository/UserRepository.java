package com.hillel.crm.dbutils.repository;

import com.hillel.crm.dbutils.connection.ConnectionProvider;
import com.hillel.crm.dbutils.entity.User;
import com.hillel.crm.dbutils.entity.UserRole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import static java.util.Objects.nonNull;

public class UserRepository extends BaseRepository {

    public Optional<User> findByNameAndPassword(String name, String password) {
        Connection connection = ConnectionProvider.provideConnection();

        if (nonNull(connection)) {
            try (PreparedStatement statement = connection
                    .prepareStatement("select * from user where name=? and password = ?")) {
                statement.setString(1, name);
                statement.setString(2, password);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    return Optional.of(new User(resultSet.getInt("id"), resultSet.getString("name"),
                            resultSet.getString("password"),
                            UserRole.valueOf(resultSet.getString("role"))));
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return Optional.empty();
            } finally {
                closeConnection(connection);
            }
        }
        return Optional.empty();
    }
}
