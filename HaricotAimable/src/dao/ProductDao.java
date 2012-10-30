/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Product;
import java.util.List;

/**
 *
 * @author adminl
 */
public interface ProductDao {


    List<Product> getProductsByCategoryId(int categoryId);
    Product getProductById(int productId);
}
