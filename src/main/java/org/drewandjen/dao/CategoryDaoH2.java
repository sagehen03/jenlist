package org.drewandjen.dao;

import org.drewandjen.model.Category;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Created by dhite on 11/12/15.
 */
public class CategoryDaoH2 implements CategoryDao {

    private JdbcTemplate template;

    public CategoryDaoH2(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Category> getCategories() {
        return template.query("SELECT name, ID FROM categories", (resultSet, i) -> {
            return new Category(resultSet.getInt("ID"), resultSet.getString("name"));
        });
    }
}
