package org.drewandjen.dao;

import org.drewandjen.model.ShoppingList;
import org.drewandjen.model.ShoppingListItem;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Created by dhite on 8/24/15.
 */
public interface ShoppingListDao {

    List<ShoppingListItem> fetchAll(int listId);

    void save(ShoppingListItem item);

    ShoppingListItem getItemById(int id);

    List<ShoppingList> fetchAllShoppingLists();

    void saveShopingList(String shoppingListName);

    void deleteShoppingListItem(List<ShoppingListItem> shoppingListItems);
}
