/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shopping;

import com.opensymphony.xwork2.ActionSupport;
import entity.Category;
import entity.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import service.HaricotService;
import service.HaricotServiceLocator;

/**
 *
 * @author adminl
 */
public class CategoryAction extends ActionSupport implements SessionAware {

    private Map<String, Object> map;

    @Override
    public void setSession(Map<String, Object> map) {
	this.map = map;
    }
    // properties
    private List<Category> categories = new ArrayList<Category>();
    private List<Product> products = new ArrayList<Product>();
    private Integer currentCategory = 1;
    // private daos
//    private CategoryDao categoryDao = new MockCategoryDao();
//    private ProductDao productDao = new MockProductDao();
    private HaricotService service = HaricotServiceLocator.getService();

    @Override
    public String execute() {

//	categories = categoryDao.getAllCategories();
//	products = productDao.getProductsByCategoryId(getCurrentCategory());

	categories = service.getAllCategories();
	Category selectedCategory = service.getCategoryById(currentCategory);
	if (selectedCategory != null) {
	    products = selectedCategory.getProductList();
	}


	return SUCCESS;

    }

    public List<Category> getCategories() {
	return categories;
    }

    public void setCategories(List<Category> categories) {
	this.categories = categories;
    }

    public List<Product> getProducts() {
	return products;
    }

    public void setProducts(List<Product> products) {
	this.products = products;
    }

    public Integer getCurrentCategory() {
	Integer catId = (Integer) map.get("currentCategory");
	if (catId == null) {
	    catId = 1;
	}
	return catId;
    }

    public void setCurrentCategory(Integer currentCategory) {
	this.currentCategory = currentCategory;
	map.put("currentCategory", currentCategory);
    }
}
