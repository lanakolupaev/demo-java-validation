package me.kolupaev.lana.validation.persistance;

import me.kolupaev.lana.validation.business.User;
import me.kolupaev.lana.validation.controller.UserAlreadyExistsException;
import org.junit.Test;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.KeyHolder;

import static org.mockito.Mockito.*;

/**
 * @author Lana Kolupaev
 * @date 2015-05-19
 */
public class JdbcUserDAOTest {

    @Test(expected=UserAlreadyExistsException.class)
    public void duplicateUsername_save_throwsUserAlreadyExistsException() throws UserAlreadyExistsException {
        JdbcUserDAO dao = new JdbcUserDAO();

        JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);
        when(jdbcTemplate.update(any(PreparedStatementCreator.class), any(KeyHolder.class))).thenThrow(new DuplicateKeyException(""));

        dao.setJdbcTemplate(jdbcTemplate);

        dao.register(new User());
    }

    @Test(expected=NullPointerException.class)
    public void user_save_otherExceptionsPropagate() throws UserAlreadyExistsException {
        JdbcUserDAO dao = new JdbcUserDAO();

        JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);
        when(jdbcTemplate.update(any(PreparedStatementCreator.class), any(KeyHolder.class))).thenThrow(new NullPointerException("")); //any exception

        dao.setJdbcTemplate(jdbcTemplate);

        dao.register(new User());
    }
}
