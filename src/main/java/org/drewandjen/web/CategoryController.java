package org.drewandjen.web;

import org.drewandjen.dao.CategoryDao;
import org.drewandjen.dao.MasterListDao;
import org.drewandjen.model.Category;
import org.drewandjen.model.MasterListItem;
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
public class CategoryController {

    private CategoryDao dao;

    public CategoryController(CategoryDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value= "/categories", method= RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Category> getItems(){
        return dao.getCategories();
    }

    @RequestMapping(value= "/categories", method= RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Category saveItem(@RequestBody Category category){
        return dao.saveCategory(category);
    }



}
