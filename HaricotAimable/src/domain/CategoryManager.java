package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author adminl
 * @version 1.0
 * @created 03-oct.-2012 11:28:36
 */
public class CategoryManager {

    private List<Category> categories = new ArrayList<>();
    
    private static CategoryManager instance = new CategoryManager();

    public static CategoryManager getInstance() {
        return instance;
    }

    private CategoryManager() {
        categories.add(new Category("Dairies"));
        categories.add(new Category("Meat"));
        categories.add(new Category("Vegetables"));
        categories.add(new Category("Bakery"));
    }

    public Category getCategoryById(int categoryId) {

        for (Category cat : categories) {
            if (cat.getId() == categoryId) {
                return cat;
            }
        }

        return null;
        /*if(categoryId > categories.size())
         return null;
         else
         return categories.get(categoryId);*/
    }

    public List<Category> getAllCategories() {
        return categories;
    }
}