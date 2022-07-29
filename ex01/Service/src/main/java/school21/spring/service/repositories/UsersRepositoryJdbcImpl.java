package school21.spring.service.repositories;

import school21.spring.service.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcImpl implements UsersRepository {
        private Connection connection;

    UsersRepositoryJdbcImpl(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> findAll() {
            List<User> usersList = new ArrayList<>();

            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery("SELECT * FROM users;")) {
                    while (resultSet.next()) {
                        User user = new User(resultSet.getLong("id"), resultSet.getString("email"));
                        usersList.add(user);
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            return usersList;
        }

        @Override
        public User findById(Long id) {
            final String SQL = "SELECT * FROM users WHERE id = ? ;";

            try (PreparedStatement statement = connection.prepareStatement(SQL)) {
                statement.setLong(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (!resultSet.next()) {
                        return null;
                    }
                    return new User(resultSet.getLong("id"), resultSet.getString("email"));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    @Override
    public void update(User user) {
            final String SQL = "UPDATE users SET email = ? WHERE id = ?;";

            try (PreparedStatement statement = connection.prepareStatement(SQL)) {
                statement.setString(1, user.getEmail());
                statement.setLong(2, user.getId());
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    @Override
    public void save(User user) {
            final String SQL = "INSERT INTO users(email) VALUES (?);";

            try (PreparedStatement statement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, user.getEmail());
                statement.executeUpdate();
                try (ResultSet resultSet = statement.getGeneratedKeys()) {
                    if (!resultSet.next())
                        return;
                    user.setId(resultSet.getLong("id"));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    @Override
    public void delete (Long id) {
            final String SQL = "DELETE FROM users WHERE id = ? ;";
            try (PreparedStatement statement = connection.prepareStatement(SQL)) {
                statement.setLong(1, id);
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        public Connection getConnection() {
            return connection;
        }

    @Override
    public Optional<User> findByEmail(String email) {
        final String SQL = "SELECT * FROM users WHERE email = ?;";

        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (!resultSet.next()) {
                    return Optional.empty();
                }
                return Optional.of(new User(resultSet.getLong("id"), resultSet.getString("email")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
