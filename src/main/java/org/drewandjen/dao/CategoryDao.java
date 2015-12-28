package org.drewandjen.dao;

import org.drewandjen.model.Category;

import java.util.List;

/**
 * Created by dhite on 11/12/15.
 */
public interface CategoryDao {

    List<Category> getCategories();

    Category saveCategory(Category category);
}
