package org.drewandjen.web;

import org.drewandjen.dao.CategoryDao;
import org.drewandjen.model.Category;
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
