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

@RestController
@EnableAutoConfiguration
@RequestMapping("/data")
public class DataController {

    @Autowired
    CategoryDAO categoryDAO;

    @RequestMapping("/")
    @ResponseBody
    String data() {
        // Should return a list of category ids
        return "some json representing a list of category ids for the user";
    }

    @RequestMapping("/{category}")
    @ResponseBody
    Category dataCategory(@PathVariable("category") String category) throws ThingDoesNotExistException {
        // Should return a list of the entries for given category

        Category c = categoryDAO.getCategoryByName(category);
        return c;
    }
}