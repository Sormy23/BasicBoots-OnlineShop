package at.ac.htlwrn.dto;

import javax.persistence.Column;
import java.sql.Timestamp;

public class PurchaseOrderDto {
    private Long id;

    private String anrede;

    private String vorname;

    private String name;

    private String street;

    private String zipCode;

    private String city;

    private Timestamp date;

    private float price;

    private Timestamp finished;

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

    public float getPrice() {
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

    public void setPrice(float price) {
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
