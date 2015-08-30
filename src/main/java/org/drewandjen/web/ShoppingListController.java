package org.drewandjen.web;

import org.drewandjen.dao.ShoppingListDao;
import org.drewandjen.model.ShoppingList;
import org.drewandjen.model.ShoppingListItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by dhite on 8/24/15.
 */
@Controller
public class ShoppingListController {

    private ShoppingListDao dao;

    private static final Logger LOG = LoggerFactory.getLogger(ShoppingListController.class);

    public ShoppingListController(ShoppingListDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value= "/shopping-list/{shoppingListId}", method= RequestMethod.GET)
    @ResponseBody
    public List<ShoppingListItem> getItems(@PathVariable Integer shoppingListId){
        LOG.info("Getting the items!");
        return dao.fetchAll(shoppingListId);
    }

    @RequestMapping(value="/shopping-list", method = RequestMethod.GET)
    @ResponseBody
    public List<ShoppingList> getShoppingLists(){
        return dao.fetchAllShoppingLists();
    }

    @RequestMapping(value="/shopping-list/{shoppingListName}", method=RequestMethod.POST)
    public ResponseEntity<String> addNewShoppingList(@PathVariable String shoppingListName){
        dao.saveShopingList(shoppingListName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="/shopping-list", method = RequestMethod.POST)
    public ResponseEntity<String> saveItem(@RequestBody ShoppingListItem shoppingListItem){
        LOG.info("Saving shopping list item {}", shoppingListItem);
        dao.save(shoppingListItem);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
