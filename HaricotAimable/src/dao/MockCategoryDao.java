/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Category;
import domain.Product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adminl
 */
public class MockCategoryDao implements CategoryDao {

    static final List<Category> database = new ArrayList<>();

    static {
        database.add(new Category(0, "dairies"));
        database.add(new Category(1, "bakery"));
        database.add(new Category(2, "vegetables"));
        database.add(new Category(3, "meats"));
    }

    @Override
    public List<Category> getAllCategories() {
        return database;
    }
}
