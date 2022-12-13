package at.ac.htlwrn.dao;

import at.ac.htlwrn.model.PurchaseOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOrderDao extends CrudRepository<PurchaseOrder, Long> {

}