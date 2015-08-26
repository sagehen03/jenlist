package org.drewandjen.web;

import org.drewandjen.dao.ListDao;
import org.drewandjen.model.ListItem;
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

    private ListDao dao;

    private static final Logger LOG = LoggerFactory.getLogger(ListController.class);

    public ListController(ListDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value= "/items", method= RequestMethod.GET)
    public List<ListItem> getItems(){
        LOG.info("Getting the items!");
        return dao.getListItems();
    }
}
