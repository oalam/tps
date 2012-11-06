package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * @author adminl
 * @version 1.0
 * @created 03-oct.-2012 11:28:36
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Category.findByName",
    query = "select c from Category c where c.name = :fname")})
public class Category implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    @Basic(optional = false)
    private int id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name = "";
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    public List<Product> products = new ArrayList<>();

    public Category(int id, String name) {
        this.id = id;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.id;
        hash = 73 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Category other = (Category) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
}