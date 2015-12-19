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

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("apiBase", System.getProperty("host") +
                (!System.getProperty("server.port").equals("80") ? ":" + System.getProperty("server.port") : ""));
        return "index";
    }

    @RequestMapping("/updateItem")
    public ResponseEntity<String> updateItemStatus(@RequestParam int itemId, @RequestParam boolean completed){
        dao.updateShoppingListItemStatus(completed, itemId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/list")
    public String index(Model model, @RequestParam(required = false) String listId,
                        @RequestParam(required =  false) String nameSort,
                        @RequestParam(required = false) String categorySort) {
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
        items = updateSortState(nameSort, categorySort, model, items);
        model.addAttribute("selectedList", listId);
        model.addAttribute("listItems", items);
        return "list";
    }

    private List<ShoppingListItem> updateSortState(String nameSort, String categorySort, Model model, List<ShoppingListItem> items) {
        model.addAttribute("categorySort", "list?categorySort=asc");
        model.addAttribute("nameSort", "list?nameSort=asc");

        if(StringUtils.isNotBlank(nameSort)){
            sort(items, model, nameSort, Comparator.comparing(ShoppingListItem::getName), "nameSort");
        }
        else if(StringUtils.isNotBlank(categorySort)){
            sort(items, model, categorySort, Comparator.comparing(ShoppingListItem::getCategory), "categorySort");
        }

        return items;
    }

    private void sort(List<ShoppingListItem> items, Model model, String sortDirection, Comparator comparator, String sortType){
        if(sortDirection.equals("asc")){
            Collections.sort(items, comparator);
            model.addAttribute(sortType, "list?"+sortType+"=desc");
        } else {
            Collections.sort(items, comparator.reversed());
            model.addAttribute(sortType, "list?"+sortType+"=asc");
        }
    }


}
