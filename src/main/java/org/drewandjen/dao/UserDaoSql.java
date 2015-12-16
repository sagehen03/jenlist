package org.drewandjen.dao;

import org.drewandjen.model.ListUser;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by dhite on 11/28/15.
 */
public class UserDaoSql implements UserDao {

    private JdbcTemplate template;

    public UserDaoSql(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<ListUser> getAllUsers() {
        return template.query("SELECT username, id FROM users", (resultSet, i) -> {
            return new ListUser(resultSet.getString("username"), resultSet.getInt("id"));
        });
    }
}
