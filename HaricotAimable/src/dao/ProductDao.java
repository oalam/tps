/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Product;
import java.util.List;

/**
 *
 * @author adminl
 */
public interface ProductDao {

    void create(Product p);
    Product read(Long id);
    void update(Product p);
    void delete(Product p);
    
    List<Product> getProductsByCategoryId(int categoryId);
    Product getProductById(int productId);
}
