package school21.spring.service.repositories;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import school21.spring.service.models.User;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {

    private final JdbcTemplate jdbcTemplate;

    public UsersRepositoryJdbcTemplateImpl(DataSource driverManager) {
        jdbcTemplate = new JdbcTemplate(driverManager);
    }

    @Override
    public User findById(Long id) {
        final String SQL = "SELECT * FROM users WHERE id = ? ;";

        User user = DataAccessUtils.singleResult(jdbcTemplate.query(SQL, new UserMapper(), id));

        return user;
    }

    @Override
    public List findAll() {
        final String SQL = "SELECT * FROM users;";
        return jdbcTemplate.query(SQL, new UserMapper());
    }

    @Override
    public void save(User entity) {
        final String SQL = "INSERT INTO users(email) VALUES (?);";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement(SQL, new String[]{"id"});
            ps.setString(1, entity.getEmail());
            return ps;
        }, keyHolder);

        entity.setId(keyHolder.getKey().longValue());
    }

    @Override
    public void update(User entity) {
        final String SQL = "UPDATE users SET email = ? WHERE id = ?;";

        jdbcTemplate.update(SQL,  entity.getEmail(), entity.getId());
    }

    @Override
    public void delete(Long id) {
        final String SQL = "DELETE FROM users WHERE id = ? ;";

       jdbcTemplate.update(SQL, id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        final String SQL = "SELECT * FROM users WHERE email = ? ;";

        User user = DataAccessUtils.singleResult(jdbcTemplate.query(SQL, new UserMapper(), email));

        return Optional.of(user);
    }

    private static class UserMapper implements RowMapper<User> {
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User(rs.getLong("id"), rs.getString("email"));
            return user;
        }
    }

}