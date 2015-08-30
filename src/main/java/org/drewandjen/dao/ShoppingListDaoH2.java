package org.drewandjen.dao;

import org.drewandjen.model.ShoppingListItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by dhite on 8/30/15.
 */
public class ShoppingListDaoH2 implements ShoppingListDao{


    private static final Logger LOG = LoggerFactory.getLogger(ShoppingListDaoH2.class);

    private JdbcTemplate template;

    public ShoppingListDaoH2(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<ShoppingListItem> fetchAll(int listId) {
        LOG.info("Getting shopping list items");
        return template.query("SELECT shopping_list_id, id, name, comment, completed, created_at FROM shopping_list_item where shopping_list_id = ?",
                (rs, i) -> {
                    return new ShoppingListItem(rs.getString("name"),
                            rs.getString("comment"), rs.getDate("created_at"), rs.getBoolean("completed"),
                            rs.getInt("shopping_list_id"), rs.getInt("id"));
                }, listId);
    }

    @Override
    public void save(ShoppingListItem item) {
        LOG.info("Saving item {}", item);
        template.update("insert into shopping_list_item(shopping_list_id, name, comment, completed, created_at) " +
                        "values (?,?,?,?,CURRENT_TIMESTAMP())",
                item.getShoppingListId(), item.getName(), item.getComment(), item.isCompleted());
    }

    @Override
    public ShoppingListItem getItemById(int id) {
        return null;
    }
}
