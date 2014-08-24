package com.pance.dao;

import com.pance.exception.ThingDoesNotExistException;
import com.pance.obj.Category;

import java.util.List;

/**
 * Created by Peter on 8/24/2014.
 */
public interface CategoryDAO {
    public List<Category> getCategories();
    public Category getCategoryByName(String name) throws ThingDoesNotExistException;
    public void createCategory(Category category);
}
