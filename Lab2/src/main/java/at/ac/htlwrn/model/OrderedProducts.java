package at.ac.htlwrn.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "orderedProducts")
public class OrderedProducts {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    Product product;

    @ManyToOne
    @JoinColumn(name = "purchasOrder_id")
    PurchaseOrder purchaseOrder;

    @Column(nullable = false)
    int quantity;

}
