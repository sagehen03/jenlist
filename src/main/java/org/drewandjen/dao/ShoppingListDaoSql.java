package org.drewandjen.dao;

import org.apache.commons.lang3.StringUtils;
import org.drewandjen.model.ShoppingList;
import org.drewandjen.model.ShoppingListItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.PreparedStatement;
import java.util.Date;
import java.util.List;

/**
 * Created by dhite on 8/30/15.
 */
public class ShoppingListDaoSql implements ShoppingListDao{


    private static final Logger LOG = LoggerFactory.getLogger(ShoppingListDaoSql.class);

    private JdbcTemplate template;

    public ShoppingListDaoSql(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<ShoppingList> getShoppingListByOwner(int ownerId){
        return template.query("select id, name, created_at from shopping_list where user_id = ?", (rs, rowNum) -> {
            return new ShoppingList(rs.getInt("id"), rs.getString("name"), rs.getDate("created_at"));
        }, ownerId);
    }

    @Override
    public void updateShoppingListItemStatus(boolean completed, int itemId, Integer userId){
        template.update("update shopping_list_item as sli set completed = ? " +
                "from shopping_list as sl where sli.shopping_list_id = sl.id " +
                "and sli.id = ? and sl.user_id = ?", completed, itemId, userId);
    }

    @Override
    public List<ShoppingListItem> fetchAll(int listId) {
        return template.query("SELECT shopping_list_id, id, name, comment, completed, created_at, category FROM shopping_list_item " +
                        "where shopping_list_id = ? order by completed asc, category",
                (rs, i) -> {
                    return new ShoppingListItem(rs.getString("name"),
                            rs.getString("comment"), rs.getDate("created_at"), rs.getBoolean("completed"),
                            rs.getInt("shopping_list_id"), rs.getInt("id"), rs.getString("category"));
                }, listId);
    }

    @Override
    public ShoppingListItem save(ShoppingListItem item) {
        LOG.info("Saving item {}", item);
        if(StringUtils.isBlank(item.getComments())){
            item.setComments(null);
        }
        PreparedStatementCreator creator = con -> {
            PreparedStatement ps = con.prepareStatement("insert into shopping_list_item(shopping_list_id, name, comment, completed, category, created_at) " +
                    "values (?,?,?,?,?,CURRENT_TIMESTAMP)", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, item.getShoppingListId());
            ps.setString(2, item.getName());
            ps.setString(3, item.getComments());
            ps.setBoolean(4, item.isCompleted());
            ps.setString(5, item.getCategory());
            return ps;

        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        template.update(creator, generatedKeyHolder);
        Integer id = (Integer) generatedKeyHolder.getKeys().get("id");
        item.setId(id);
        return item;
    }

    @Override
    public List<ShoppingList> fetchAllShoppingLists(Integer userId) {
        return template.query("select id, name, created_at from shopping_list where user_id = ? order by name", (rs, i) -> {
            return new ShoppingList(rs.getInt("id"), rs.getString("name"), rs.getDate("created_at"));
        }, userId);
    }

    @Override
    public ShoppingList saveShopingList(String shoppingListName, Integer userId) {
        PreparedStatementCreator creator = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into shopping_list(name, user_id, created_at) " +
                    "values(?, ?, CURRENT_TIMESTAMP)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, shoppingListName);
            preparedStatement.setInt(2, userId);
            return preparedStatement;
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        template.update(creator, generatedKeyHolder);
        return new ShoppingList((Integer) generatedKeyHolder.getKeys().get("id"), shoppingListName, new Date());
    }

    @Override
    public void deleteShoppingListItem(int id, Integer userId) {
        template.update("delete from shopping_list_item using shopping_list where shopping_list_id = shopping_list.id and " +
                "shopping_list_item.id = ? and shopping_list.user_id = ?", id, userId);
    }

    @Override
    public void updateShoppingListItems(List<ShoppingListItem> itemsToUpdate, Integer userId) {
        for (ShoppingListItem shoppingListItem : itemsToUpdate) {
            template.update("update shopping_list_item set completed = ?, name = ?, comment = ? where id = ? and user_id = ?",
                    shoppingListItem.isCompleted(), shoppingListItem.getName(), shoppingListItem.getComments(),
                    shoppingListItem.getId(), userId);
        }
    }
}
