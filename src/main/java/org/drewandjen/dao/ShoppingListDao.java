package org.drewandjen.dao;

import org.drewandjen.model.ShoppingList;
import org.drewandjen.model.ShoppingListItem;

import java.util.List;

/**
 * Created by dhite on 8/24/15.
 */
public interface ShoppingListDao {

    List<ShoppingList> getShoppingListByOwner(int ownerId);

    void updateShoppingListItemStatus(boolean completed, int itemId);

    List<ShoppingListItem> fetchAll(int listId);

    void save(ShoppingListItem item);

    List<ShoppingList> fetchAllShoppingLists(Integer userId);

    ShoppingList saveShopingList(String shoppingListName, Integer userId);

    void deleteShoppingListItem(int id);

    void updateShoppingListItems(List<ShoppingListItem> itemsToUpdate, Integer userId);
}
