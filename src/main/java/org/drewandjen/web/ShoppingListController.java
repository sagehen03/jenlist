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
public class ShoppingListController {

    private final UserInfoCache userInfoCache;

    private ShoppingListDao dao;

    private static final Logger LOG = LoggerFactory.getLogger(ShoppingListController.class);

    public ShoppingListController(ShoppingListDao dao, UserInfoCache userInfoCache) {
        this.dao = dao;
        this.userInfoCache = userInfoCache;
    }

    @RequestMapping(value="/shopping-list", method = RequestMethod.GET)
    @ResponseBody
    public List<ShoppingList> getShoppingLists(){
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        return dao.fetchAllShoppingLists(userInfoCache.getUserId(userName));
    }


    @RequestMapping(value="/shopping-list", method = RequestMethod.POST)
    @ResponseBody
    public ShoppingList saveNewShoppingList(@RequestBody ShoppingList newList){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return dao.saveShopingList(newList.getName(), userInfoCache.getUserId(authentication.getName()));
    }
}
