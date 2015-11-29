package org.drewandjen.web;

import org.apache.commons.lang3.StringUtils;
import org.drewandjen.dao.ShoppingListDao;
import org.drewandjen.model.MasterListItem;
import org.drewandjen.model.ShoppingList;
import org.drewandjen.model.ShoppingListItem;
import org.drewandjen.model.UserInfoCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by dhite on 8/24/15.
 */
@Controller
public class ShoppingListController {

    private final UserInfoCache userInfoCache;

    private ShoppingListDao dao;

    private static final Logger LOG = LoggerFactory.getLogger(ShoppingListController.class);

    public ShoppingListController(ShoppingListDao dao, UserInfoCache userInfoCache) {
        this.dao = dao;
        this.userInfoCache = userInfoCache;
    }

    @RequestMapping(value= "/shopping-list/{shoppingListId}", method= RequestMethod.GET)
    @ResponseBody
    public List<ShoppingListItem> getItems(@PathVariable Integer shoppingListId){
        return dao.fetchAll(shoppingListId);
    }

    @RequestMapping(value="/shopping-list", method = RequestMethod.GET)
    @ResponseBody
    public List<ShoppingList> getShoppingLists(){
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        return dao.fetchAllShoppingLists(userInfoCache.getUserId(userName));
    }


    @RequestMapping(value="/shopping-list/{listIdOrNewList}", method = RequestMethod.POST)
    public ResponseEntity<String> saveItem(@PathVariable String listIdOrNewList, @RequestBody ShoppingListItem shoppingListItem){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(StringUtils.isNumeric(listIdOrNewList)){
            LOG.info("Saving shopping list item {}", shoppingListItem);
            shoppingListItem.setShoppingListId(Integer.parseInt(listIdOrNewList));
            dao.save(shoppingListItem);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            dao.saveShopingList(listIdOrNewList, userInfoCache.getUserId(authentication.getName()));
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/shopping-list/{listId}/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<String> deleteItem(@PathVariable Integer listId, @PathVariable Integer id){
        dao.deleteShoppingListItem(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="/shopping-list", method = RequestMethod.PUT)
    public ResponseEntity<String> updateShoppingListItems(@RequestBody List<ShoppingListItem> itemsToUpdate){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        dao.updateShoppingListItems(itemsToUpdate, userInfoCache.getUserId(authentication.getName()));
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
