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
public class EmptyDao implements ProductDao{

    @Override
    public List<Product> getProductsByCategoryId(int categoryId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Product getProductById(int productId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void create(Product p) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Product read(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Product p) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Product p) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
