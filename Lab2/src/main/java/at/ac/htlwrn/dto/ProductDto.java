package at.ac.htlwrn.dto;

import at.ac.htlwrn.model.OrderedProducts;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.Set;

public class ProductDto {
    private Long id;

    Set<OrderedProducts> purchases;

    private String name;

    private String desc;

    private double price;

    private String img;

    private Date gueltig_ab;

    private Date gueltig_bis;

    //Get methods

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDesc() {
        return desc;
    }

    public String getImg() {
        return img;
    }

    public Date getGueltig_ab() {
        return gueltig_ab;
    }

    public Date getGueltig_bis() {
        return gueltig_bis;
    }

    //set methods

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setGueltig_ab(Date gueltig_ab) {
        this.gueltig_ab = gueltig_ab;
    }

    public void setGueltig_bis(Date gueltig_bis) {
        this.gueltig_bis = gueltig_bis;
    }
}
