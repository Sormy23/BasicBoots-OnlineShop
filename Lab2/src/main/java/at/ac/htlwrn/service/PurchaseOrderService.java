package at.ac.htlwrn.service;

import at.ac.htlwrn.dto.PurchaseOrderDto;
import at.ac.htlwrn.model.PurchaseOrder;

import java.util.List;

public interface PurchaseOrderService {
    /**
     * Save new order
     * @param order {@link at.ac.htlwrn.model.PurchaseOrder} with order details
     * @return instance of {@link at.ac.htlwrn.model.PurchaseOrder}
     */

    PurchaseOrder save(PurchaseOrderDto order);

    /**
     * returns a list of orders depending on the parameters
     * @param storniert specifies if an order is canceled
     * @param erledigt specifies if an order is done
     * @return Returns a list of {@link PurchaseOrder}
     */

    List<PurchaseOrder> find(boolean storniert, boolean erledigt);

    /**
     * cancels the given order
     * @param id of purchaseOrder
     */
    void cancel(Long id);

    /**
     * finishes an order
     * @param id of purchaseOrder
     */
    void finish(Long id);
}
