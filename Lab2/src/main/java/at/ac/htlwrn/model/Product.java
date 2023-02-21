package at.ac.htlwrn.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    //n:m-Beziehung

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, orphanRemoval = true)
    Set<OrderedProducts> purchases;

    //end

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String desc;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private String img;

    @Column
    private Timestamp gueltig_ab;

    @Column
    private Timestamp gueltig_bis;

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

    public Timestamp getGueltig_ab() {
        return gueltig_ab;
    }

    public Timestamp getGueltig_bis() {
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

    public void setGueltig_ab(Timestamp gueltig_ab) {
        this.gueltig_ab = gueltig_ab;
    }

    public void setGueltig_bis(Timestamp gueltig_bis) {
        this.gueltig_bis = gueltig_bis;
    }
}
