package org.drewandjen.dao;

import org.drewandjen.model.ShoppingList;
import org.drewandjen.model.ShoppingListItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

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
        return template.query("SELECT shopping_list_id, id, name, comment, completed, created_at, category FROM shopping_list_item " +
                        "where shopping_list_id = ? order by category",
                (rs, i) -> {
                    return new ShoppingListItem(rs.getString("name"),
                            rs.getString("comment"), rs.getDate("created_at"), rs.getBoolean("completed"),
                            rs.getInt("shopping_list_id"), rs.getInt("id"), rs.getString("category"));
                }, listId);
    }

    @Override
    public void save(ShoppingListItem item) {
        LOG.info("Saving item {}", item);
        template.update("insert into shopping_list_item(shopping_list_id, name, comment, completed, category, created_at) " +
                        "values (?,?,?,?,?,CURRENT_TIMESTAMP())",
                item.getShoppingListId(), item.getName(), item.getComments(), item.isCompleted(), item.getCategory());
    }

    @Override
    public ShoppingListItem getItemById(int id) {
        return null;
    }

    @Override
    public List<ShoppingList> fetchAllShoppingLists() {
        return template.query("select id, name, created_at from shopping_list order by name", (rs, i) -> {
            return new ShoppingList(rs.getInt("id"), rs.getString("name"), rs.getDate("created_at"));
        });
    }

    @Override
    public void saveShopingList(String shoppingListName) {
        template.update("insert into shopping_list(name, created_at) values(?, CURRENT_TIMESTAMP())", shoppingListName);
    }

    @Override
    public void deleteShoppingListItem(int id) {
        template.update("delete from shopping_list_item where id = ?", id);
    }

    @Override
    public void updateShoppingListItems(List<ShoppingListItem> itemsToUpdate) {
        for (ShoppingListItem shoppingListItem : itemsToUpdate) {
            template.update("update shopping_list_item set completed = ?, name = ?, comment = ? where id = ?",
                    shoppingListItem.isCompleted(), shoppingListItem.getName(), shoppingListItem.getComments(), shoppingListItem.getId());
        }
    }
}
