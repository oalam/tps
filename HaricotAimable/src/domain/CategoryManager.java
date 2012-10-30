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
        categories.add(new Category(0,"Dairies"));
        categories.add(new Category(1,"Meat"));
        categories.add(new Category(2,"Vegetables"));
        categories.add(new Category(3,"Bakery"));
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