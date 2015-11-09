package org.drewandjen.web;

import org.apache.commons.lang3.StringUtils;
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


    @RequestMapping(value="/shopping-list/{listIdOrNewList}", method = RequestMethod.POST)
    public ResponseEntity<String> saveItem(@PathVariable String listIdOrNewList, @RequestBody ShoppingListItem shoppingListItem){
        if(StringUtils.isNumeric(listIdOrNewList)){
            LOG.info("Saving shopping list item {}", shoppingListItem);
            shoppingListItem.setShoppingListId(Integer.parseInt(listIdOrNewList));
            dao.save(shoppingListItem);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            dao.saveShopingList(listIdOrNewList);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @RequestMapping(value="/shopping-list", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteItem(@RequestBody List<ShoppingListItem> shoppingListItem){
        dao.deleteShoppingListItem(shoppingListItem);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="/shopping-list", method = RequestMethod.PUT)
    public ResponseEntity<String> updateShoppingListItems(@RequestBody List<ShoppingListItem> itemsToUpdate){
        dao.updateShoppingListItems(itemsToUpdate);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
