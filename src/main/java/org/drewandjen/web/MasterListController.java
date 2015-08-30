package org.drewandjen.web;

import org.drewandjen.dao.MasterListDao;
import org.drewandjen.model.MasterListItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by dhite on 8/24/15.
 */
@Controller
public class MasterListController {

    private MasterListDao dao;

    private static final Logger LOG = LoggerFactory.getLogger(MasterListController.class);

    public MasterListController(MasterListDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value= "/master-list", method= RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<MasterListItem> getItems(){
        LOG.info("Retrieving items");
        return dao.fetchAll();
    }

    @RequestMapping(value = "/master-list", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<String> saveItem(@RequestBody MasterListItem newItem){
        dao.save(newItem);
        LOG.info("Saving item {}", newItem);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/master-list/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<String> deleteItem(@PathVariable Integer id){
        LOG.info("About to delete item {}", id);
        dao.delete(new MasterListItem(id, ""));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
