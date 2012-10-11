package domain;

import java.util.ArrayList;
import java.util.List;
import utils.IdGenerator;

/**
 * @author adminl
 * @version 1.0
 * @created 03-oct.-2012 11:28:36
 */
public class Category {

    private int id = IdGenerator.getNextId();
    private String name = "";
    public List<Product> products = new ArrayList<>();

    public Category(String name) {
        this.name = name;
    }

    public Category() {
    }

    public List<Product> getProducts() {
        return products;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}