package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue
    @Column(name="id")
    @Basic(optional=false)
    private Long id;
    
    
    
    @Column(name="description")
    private String description;
    
    @Basic(optional=false)
    @Column(name="name")
    private String name;
    
    @Column(name="photo_url", length=512)
    private String photoUrl;
    
    @Basic(optional=false)
    @Column(name="price")
    private double price;
    
    @Basic(optional=false)
    @Column(name="stock_quantity")
    private int stockQuantity;
    
    @ManyToOne
    @JoinColumn(name="category_fk")
    private Category category;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date lastUpdate = new Date();

    public Product( String name, String description, String photoUrl, double price, int stockQuantity, Category category) {
        this.description = description;
        this.name = name; 
        this.photoUrl = photoUrl;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.category = category;
    }

    public Product() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 53 * hash + Objects.hashCode(this.description);
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + Objects.hashCode(this.photoUrl);
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 53 * hash + this.stockQuantity;
     //   hash = 53 * hash + Objects.hashCode(this.category);
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
        final Product other = (Product) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.photoUrl, other.photoUrl)) {
            return false;
        }
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (this.stockQuantity != other.stockQuantity) {
            return false;
        }
        if (!Objects.equals(this.category, other.category)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", description=" + description + ", name=" + name + ", photoUrl=" + photoUrl + ", price=" + price + ", stockQuantity=" + stockQuantity + ", category=" + category + '}';
    }

    

    
    

}