/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import domain.Product;

/**
 *
 * @author adminl
 */
public interface ProductDao {
    void create(Product p);
    void read(Product P);
    void update(Product p);
    void delete(Product p);
}
