/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adminl
 */
public class MockProductDao implements ProductDao {

    static final List<Product> database = new ArrayList<>();

    static {

        // dairies
        database.add(new Product("milk", "good milk", "http://google.com", 1.59, 12, null));
        database.add(new Product("cream", "good cream", "http://google.com", 3.59, 2, null));

        // bakery
        database.add(new Product("bread", "good bread", "http://google.com", 1.59, 12, null));
        database.add(new Product("croissant", "good cream", "http://google.com", 3.59, 21, null));
        database.add(new Product("cake", "good cake", "http://google.com", 7.59, 18, null));
        
        // vegetables
        database.add(new Product("eeg plant", "miam", "http://google.com", 4.59, 21, null));
        database.add(new Product("tomato", "very red", "http://google.com", 5.59, 12, null));
        database.add(new Product("cumcumber", "masqued", "http://google.com", 3.59, 2, null));
        
        // meats
        database.add(new Product("beef", "very fresh", "http://google.com", 19.59, 12, null));
        database.add(new Product("lamb", "zzzzz", "http://google.com", 23.59, 2, null));
    }

    @Override
    public List<Product> getProductsByCategoryId(int categoryId) {
        List<Product> products = new ArrayList<>();
        
        for (Product product : database) {
            if(product.getCategory().getId() == categoryId){
                products.add(product);
            }
        }
        
        return products;
    }

    @Override
    public Product getProductById(int productId) {
       for (Product product : database) {
            if(product.getId() == productId){
                return product;
            }
        }
       return null;
    }
}
