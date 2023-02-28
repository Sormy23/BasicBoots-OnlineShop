package at.ac.htlwrn.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "productOrder")
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    //end

    @Column(nullable = false)
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
    private Timestamp date;

    @Column(nullable = false)
    private double price;

    @Column
    private Timestamp finished;

    @Column
    private Timestamp canceled;

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

    public Timestamp getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }

    public Timestamp getCanceled() {
        return canceled;
    }

    public Timestamp getFinished() {
        return finished;
    }

    public void setAnrede(String anrede) {
        this.anrede = anrede;
    }

    public void setCanceled(Timestamp canceled) {
        this.canceled = canceled;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public void setFinished(Timestamp finished) {
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
}
