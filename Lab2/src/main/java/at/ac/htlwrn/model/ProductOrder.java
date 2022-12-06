package at.ac.htlwrn.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "productOrder")
public class ProductOrder {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String anrede;

    @Column
    private String vorname;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String adress; //full adress needed

    @Column(nullable = false)
    private Timestamp date;

    @Column(nullable = false)
    private float price;

    @Column
    private Timestamp erledigt;

    @Column
    private Timestamp storniert;
}
