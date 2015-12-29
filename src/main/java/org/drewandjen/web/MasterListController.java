package org.drewandjen.web;

import org.drewandjen.dao.MasterListDao;
import org.drewandjen.model.MasterListItem;
import org.drewandjen.model.UserInfoCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by dhite on 8/24/15.
 */
@Controller
public class MasterListController {

    private final UserInfoCache userInfoCache;

    private MasterListDao dao;

    private static final Logger LOG = LoggerFactory.getLogger(MasterListController.class);

    public MasterListController(MasterListDao dao, UserInfoCache userInfoCache) {
        this.userInfoCache = userInfoCache;
        this.dao = dao;
    }

    @RequestMapping(value= "/master-list", method= RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<MasterListItem> getItems(){
        LOG.info("Retrieving items");
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        return dao.fetchAll(userInfoCache.getUserId(userName));
    }

    @RequestMapping(value = "/master-list", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public MasterListItem saveItem(@RequestBody MasterListItem newItem){
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        return dao.save(newItem, userInfoCache.getUserId(userName));
    }

    @RequestMapping(value = "/master-list/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteItem(@PathVariable Integer id){
        LOG.info("About to delete item {}", id);
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        dao.delete(new MasterListItem(id, "", ""), userInfoCache.getUserId(userName));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
