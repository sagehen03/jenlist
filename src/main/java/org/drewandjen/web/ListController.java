package org.drewandjen.web;

import org.drewandjen.dao.ShoppingListDao;
import org.drewandjen.model.ShoppingListItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by dhite on 8/24/15.
 */
@RestController
public class ListController {

    private ShoppingListDao dao;

    private static final Logger LOG = LoggerFactory.getLogger(ListController.class);

    public ListController(ShoppingListDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value= "/items", method= RequestMethod.GET)
    public List<ShoppingListItem> getItems(){
        LOG.info("Getting the items!");
        return dao.fetchAll(1);
    }
}
