/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shopping;

import com.opensymphony.xwork2.ActionSupport;
import dao.CategoryDao;
import dao.MockCategoryDao;
import dao.MockProductDao;
import dao.ProductDao;
import domain.Category;
import domain.Product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adminl
 */
public class CategoryAction extends ActionSupport {

    // properties
    private List<Category> categories = new ArrayList<Category>();
    private int selectedCat;
    private List<Product> products = new ArrayList<Product>();

    // private daos
    private CategoryDao categoryDao = new MockCategoryDao();
    private ProductDao productDao = new MockProductDao();
    
    
    @Override
    public String execute() {
        
        categories = categoryDao.getAllCategories();
        products = productDao.getProductsByCategoryId(selectedCat);

        return SUCCESS;

    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }


    public int getSelectedCat() {
        return selectedCat;
    }

    public void setSelectedCat(int selectedCat) {
        this.selectedCat = selectedCat;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
