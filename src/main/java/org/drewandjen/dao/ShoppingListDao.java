package org.drewandjen.dao;

import org.drewandjen.model.ShoppingListItem;

import java.util.List;

/**
 * Created by dhite on 8/24/15.
 */
public interface ShoppingListDao {

    List<ShoppingListItem> fetchAll(int listId);

    void save(ShoppingListItem item);

    ShoppingListItem getItemById(int id);

}
