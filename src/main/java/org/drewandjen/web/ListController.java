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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by dhite on 12/7/15.
 */
@Controller
public class ListController {

    private static final Logger LOG = LoggerFactory.getLogger(ListController.class);

    private ShoppingListDao dao;

    private final UserInfoCache userInfoCache;

    public ListController(ShoppingListDao dao, UserInfoCache cache) {
        this.dao = dao;
        userInfoCache = cache;
    }

    @RequestMapping("/updateItem")
    public ResponseEntity<String> updateItemStatus(@RequestParam int itemId, @RequestParam boolean completed){
        LOG.info("Woot woot calling update item");
        dao.updateShoppingListItemStatus(completed, itemId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/list")
    public String index(Model model, @RequestParam(required = false) String listId) {
        LOG.info("The list id was {}", listId);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<ShoppingList> shoppingLists = dao.getShoppingListByOwner(userInfoCache.getUserId(authentication.getName()));
        model.addAttribute("shoppingLists", shoppingLists);
        List<ShoppingListItem> items = null;
        if (StringUtils.isNotBlank(listId)) {
            items = dao.fetchAll(Integer.parseInt(listId));
        } else {
            int id = shoppingLists.get(0).getId();
            items = dao.fetchAll(id);
            listId = String.valueOf(id);
        }
        model.addAttribute("selectedList", listId);
        model.addAttribute("listItems", items);
        return "list";
    }

}
