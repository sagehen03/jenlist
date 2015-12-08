package org.drewandjen.web;

import org.apache.commons.lang3.StringUtils;
import org.drewandjen.dao.ShoppingListDao;
import org.drewandjen.model.ShoppingList;
import org.drewandjen.model.ShoppingListItem;
import org.drewandjen.model.UserInfoCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by dhite on 8/24/15.
 */
@Controller
public class ShoppingListItemController {

    private final UserInfoCache userInfoCache;

    private ShoppingListDao dao;

    private static final Logger LOG = LoggerFactory.getLogger(ShoppingListItemController.class);

    public ShoppingListItemController(ShoppingListDao dao, UserInfoCache userInfoCache) {
        this.dao = dao;
        this.userInfoCache = userInfoCache;
    }

    @RequestMapping(value= "/shopping-list-items/{shoppingListId}", method= RequestMethod.GET)
    @ResponseBody
    public List<ShoppingListItem> getItems(@PathVariable Integer shoppingListId){
        return dao.fetchAll(shoppingListId);
    }

    @RequestMapping(value="/shopping-list-items/{listId}", method = RequestMethod.POST)
    public ResponseEntity<String> saveItem(@PathVariable String listId, @RequestBody ShoppingListItem shoppingListItem){
        if(StringUtils.isNumeric(listId)){
            LOG.info("Saving shopping list item {}", shoppingListItem);
            shoppingListItem.setShoppingListId(Integer.parseInt(listId));
            dao.save(shoppingListItem);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/shopping-list-items/{listId}/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<String> deleteItem(@PathVariable Integer listId, @PathVariable Integer id){
        dao.deleteShoppingListItem(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="/shopping-list-items", method = RequestMethod.PUT)
    public ResponseEntity<String> updateShoppingListItems(@RequestBody List<ShoppingListItem> itemsToUpdate){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        dao.updateShoppingListItems(itemsToUpdate, userInfoCache.getUserId(authentication.getName()));
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
