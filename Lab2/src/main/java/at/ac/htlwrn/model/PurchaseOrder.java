package at.ac.htlwrn.model;

import org.hibernate.criterion.Order;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "productOrder")
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    //n:m-Beziehung

    @OneToMany(mappedBy = "productOrder", fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, orphanRemoval = true)
    Set<OrderedProducts> products;

    //end

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
