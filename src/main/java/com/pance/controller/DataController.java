package com.pance.controller;

import com.pance.dao.CategoryDAO;
import com.pance.exception.ThingDoesNotExistException;
import com.pance.obj.Category;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.json.*;

import java.util.Date;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/data")
public class DataController {

    @Autowired
    CategoryDAO categoryDAO;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    Category[] dataGET() throws ThingDoesNotExistException {
        // Should return a list of data category ids

        List<Category> categoryList = categoryDAO.getCategories();
        return categoryList.toArray(new Category[categoryList.size()]);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    Category dataPOST(@RequestBody String categoryJSON) {
        JSONObject parsedCategoryJSON = new JSONObject(categoryJSON);
        String categoryName = parsedCategoryJSON.getString("categoryName");
        Category newCategory = new Category(new Date(System.currentTimeMillis()), categoryName);
        categoryDAO.createCategory(newCategory);
        return newCategory;
    }

    @RequestMapping(value = "/{category}", method = RequestMethod.GET)
    @ResponseBody
    Category dataCategory(@PathVariable("category") String category) throws ThingDoesNotExistException {
        // Should return a list of the entries for given category

        Category c = categoryDAO.getCategoryByName(category);
        return c;
    }
}