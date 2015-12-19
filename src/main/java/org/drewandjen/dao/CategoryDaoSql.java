package org.drewandjen.dao;

import org.drewandjen.model.Category;
import org.springframework.jdbc.core.JdbcTemplate;

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
    public void saveCategory(Category category) {
        template.update("insert into categories (name, created_at) values(?, current_time)", category.getName());
    }
}
