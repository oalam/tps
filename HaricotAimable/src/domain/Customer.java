package domain;

import utils.IdGenerator;

/**
 * @author adminl
 * @version 1.0
 * @created 03-oct.-2012 11:28:36
 */
public class Customer {

    private int id = IdGenerator.getNextId();
    
    private String name;
    private String address;
    private String paymentInfos;

    public Customer(String name, String address, String paymentInfos) {
        this.name = name;
        this.address = address;
        this.paymentInfos = paymentInfos;
    }
    
    public Customer(){
        
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPaymentInfos(String paymentInfos) {
        this.paymentInfos = paymentInfos;
    }

    
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPaymentInfos() {
        return paymentInfos;
    }

    

    
 

}