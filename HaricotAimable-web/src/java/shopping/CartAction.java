/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shopping;

import com.opensymphony.xwork2.ActionSupport;
import dao.MockProductDao;
import dao.ProductDao;
import domain.Product;

/**
 *
 * @author adminl
 */
public class CartAction extends ActionSupport{
    
    private int productId;
    
    private int selectedCat;

    public int getSelectedCat() {
        return selectedCat;
    }

    public void setSelectedCat(int selectedCat) {
        this.selectedCat = selectedCat;
    }
    
    

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
    
    @Override
    public String execute() {

     
        ProductDao productDao = new MockProductDao();
        Product product = productDao.getProductById(productId);

        System.out.println("add product = " + product.getName());
        
        
        return SUCCESS;

    }
}
