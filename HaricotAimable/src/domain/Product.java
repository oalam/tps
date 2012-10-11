package domain;

import utils.IdGenerator;

/**
 * @author adminl
 * @version 1.0
 * @created 03-oct.-2012 11:28:36
 */
public class Product {

    private int id;
    private String description;
    private String name;
    private String photoUrl;
    private double price;
    private int stockQuantity;

    public Product( String name, String description, String photoUrl, double price, int stockQuantity) {
        this.description = description;
        this.name = name; 
        this.photoUrl = photoUrl;
        this.price = price;
        this.stockQuantity = stockQuantity;
        
        this.id = IdGenerator.getNextId();
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }


    
    

}