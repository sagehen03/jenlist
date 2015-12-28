package org.drewandjen.web;

import org.drewandjen.dao.ShoppingListDao;
import org.drewandjen.model.ShoppingList;
import org.drewandjen.model.UserInfoCache;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by dhite on 8/24/15.
 */
@Controller
public class ShoppingListController {

    private final UserInfoCache userInfoCache;

    private ShoppingListDao dao;

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


    @RequestMapping(value="/shopping-list", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ShoppingList saveNewShoppingList(@RequestBody ShoppingList newList){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return dao.saveShopingList(newList.getName(), userInfoCache.getUserId(authentication.getName()));
    }
}
