package me.kolupaev.lana.validation.persistance;

import me.kolupaev.lana.validation.business.User;
import me.kolupaev.lana.validation.controller.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Lana Kolupaev
 * @date 2015-05-18
 */
@Repository
public class JdbcUserDAO implements IUserDAO {
    private static String QUERY_CREATE_USER = "INSERT INTO user (username, password) VALUES (?, ?)";
    private static String QUERY_CHECK_USERNAME_AVAILABILITY = "SELECT count(*) FROM user WHERE username = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void register(User user) throws UserAlreadyExistsException {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        try {
            jdbcTemplate.update(
                    new PreparedStatementCreator() {
                        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                            PreparedStatement ps =
                                    connection.prepareStatement(QUERY_CREATE_USER, new String[]{"id"});
                            ps.setString(1, user.getUsername());
                            ps.setString(2, user.getPassword());
                            return ps;
                        }
                    },
                    keyHolder);
        } catch (DuplicateKeyException e) {
            throw new UserAlreadyExistsException();
        }
    }

    @Override
    public boolean isUsernameAvailable(String username) {
        int count = jdbcTemplate.queryForObject(QUERY_CHECK_USERNAME_AVAILABILITY, new Object[] {username}, Integer.class);
        if (count > 0) {
            return false;
        }
        return true;
    }

    //for unit tests
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
