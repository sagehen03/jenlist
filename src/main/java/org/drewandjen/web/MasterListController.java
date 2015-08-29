package org.drewandjen.web;

import org.drewandjen.dao.MasterListDao;
import org.drewandjen.model.MasterListItem;
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
public class MasterListController {

    private MasterListDao dao;

    private static final Logger LOG = LoggerFactory.getLogger(MasterListController.class);

    public MasterListController(MasterListDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value= "/master-list", method= RequestMethod.GET)
    public List<MasterListItem> getItems(){
        LOG.info("Getting the items!");
        return dao.fetchAll();
    }
}
