package at.ac.htlwrn.model;

import javax.persistence.*;
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
    private float price;

    @Column
    private Timestamp finished;

    @Column
    private Timestamp canceled;
}
