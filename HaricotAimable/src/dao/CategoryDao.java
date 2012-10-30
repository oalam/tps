/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Category;
import java.util.List;

/**
 *
 * @author adminl
 */
public interface CategoryDao {
    List<Category> getAllCategories();
}
