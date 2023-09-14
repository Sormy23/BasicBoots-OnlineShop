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


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
