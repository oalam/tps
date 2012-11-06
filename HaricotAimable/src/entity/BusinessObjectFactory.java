/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author adminl
 */
public class BusinessObjectFactory {

    public static HashMap<String, Category> createSampleCategoryList() {

        HashMap<String, Category> categories = new HashMap<>();

        // dairies
        Category category1 = new Category();
        List<Product> database1 = new ArrayList<>();
        category1.setName("dairies");
        database1.add(new Product("milk", "good milk", "http://google.com", 1.59, 12, category1));
        database1.add(new Product("cream", "good cream", "http://google.com", 3.59, 2, category1));
        category1.setProducts(database1);
        categories.put("dairies", category1);

        // bakery
        Category category2 = new Category();
        List<Product> database2 = new ArrayList<>();
        category2.setName("bakery");
        database2.add(new Product("bread", "good bread", "http://google.com", 1.59, 12, category2));
        database2.add(new Product("croissant", "good cream", "http://google.com", 3.59, 21, category2));
        database2.add(new Product("cake", "good cake", "http://google.com", 7.59, 18, category2));
        category2.setProducts(database2);
        categories.put("bakery", category2);

        // vegetables
        Category category3 = new Category();
        List<Product> database3 = new ArrayList<>();
        category3.setName("vegetables");
        database3.add(new Product("eeg plant", "miam", "http://google.com", 4.59, 21, category3));
        database3.add(new Product("tomato", "very red", "http://google.com", 5.59, 12, category3));
        database3.add(new Product("cumcumber", "masqued", "http://google.com", 3.59, 2, category3));
        category3.setProducts(database3);
        categories.put("vegetables", category3);

        // meats
        Category category4 = new Category();
        List<Product> database4 = new ArrayList<>();
        category4.setName("meats");
        database4.add(new Product("beef", "very fresh", "http://google.com", 19.59, 12, category4));
        database4.add(new Product("lamb", "zzzzz", "http://google.com", 23.59, 2, category4));
        category4.setProducts(database4);
        categories.put("meats", category4);

        return categories;
    }
}
