package at.ac.htlwrn.dto;

import at.ac.htlwrn.model.OrderedProducts;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class PurchaseOrderDto {
    private Long id;

    private String anrede;

    private String vorname;

    private String name;

    private String street;

    private String zipCode;

    private String city;

    private Date date;

    private double price;

    private Date finished;

    private Date canceled;

    private List<ProductDto> productList;

    public Long getId() {
        return id;
    }

    public String getAnrede() {
        return anrede;
    }

    public String getVorname() {
        return vorname;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public Date getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }

    public Date getCanceled() {
        return canceled;
    }

    public Date getFinished() {
        return finished;
    }

    public void setAnrede(String anrede) {
        this.anrede = anrede;
    }

    public void setCanceled(Date canceled) {
        this.canceled = canceled;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setFinished(Date finished) {
        this.finished = finished;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public List<ProductDto> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductDto> productList) {
        this.productList = productList;
    }
}
