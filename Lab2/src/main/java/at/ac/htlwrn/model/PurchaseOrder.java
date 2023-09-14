package at.ac.htlwrn.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "productOrder")
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String anrede;

    @Column
    private String vorname;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String zipCode;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private double price;

    @Column
    private Date finished;

    @Column
    private Date canceled;

    //m-n
    @OneToMany(mappedBy = "purchaseOrder", fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, orphanRemoval = true)
    List<OrderedProducts> productList;

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


    public List<OrderedProducts> getProductList() {
        return productList;
    }

    public void setProductList(List<OrderedProducts> productList) {
        this.productList = productList;
    }

}
