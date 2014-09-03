package com.pance.dao;

import com.pance.exception.ThingDoesNotExistException;
import com.pance.obj.Category;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Peter on 8/24/2014.
 */
@Service
public class CategoryDAOImpl implements CategoryDAO {

    private ArrayList<Category> categories;

    @PostConstruct
    private void initialize() {
        categories = new ArrayList<Category>();
        categories.add(new Category(new Date(), "Category!"));
        categories.add(new Category(new Date(), "Farts!"));
        categories.add(new Category(new Date(), "Lols!"));
    }

    @Override
    public List<Category> getCategories() {
        return categories;
    }

    @Override
    public Category getCategoryByName(String name) throws ThingDoesNotExistException {
        for(Category c : categories)
            if(c.getName().equals(name))
                return c;
        throw new ThingDoesNotExistException("The Category '"+ name + "' does not exist.");
    }

    @Override
    public void createCategory(Category category) {
        categories.add(new Category(category.getCreatedDate(), category.getName()));
    }
}
