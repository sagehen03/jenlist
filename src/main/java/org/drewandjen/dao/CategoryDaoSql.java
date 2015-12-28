package org.drewandjen.dao;

import org.drewandjen.model.Category;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.util.List;

/**
 * Created by dhite on 11/12/15.
 */
public class CategoryDaoSql implements CategoryDao {

    private JdbcTemplate template;

    public CategoryDaoSql(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Category> getCategories() {
        return template.query("SELECT name, ID FROM categories order by name", (resultSet, i) -> {
            return new Category(resultSet.getInt("ID"), resultSet.getString("name"));
        });
    }

    @Override
    public Category saveCategory(Category category) {
        PreparedStatementCreator pc = con -> {
            PreparedStatement ps = con.prepareStatement("insert into categories (name, created_at) values(?, current_timestamp)", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, category.getName());
            return ps;
        };
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(pc, keyHolder);
        return new Category((Integer)keyHolder.getKeys().get("id"), category.getName());
    }
}
