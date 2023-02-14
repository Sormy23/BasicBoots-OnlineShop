package at.ac.htlwrn.dao;

import at.ac.htlwrn.model.PurchaseOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PurchaseOrderDao extends CrudRepository<PurchaseOrder, Long> {

    @Override
    Optional<PurchaseOrder> findById(Long aLong);

    @Override
    <S extends PurchaseOrder> S save(S entity);

    Optional<PurchaseOrder> findByName(String name);

    List<PurchaseOrder> findAllByZipCode(String zipcode);

    List<PurchaseOrder> findAllByCity(String city);

    List<PurchaseOrder> findAllByFinishedIsNotNull();

    List<PurchaseOrder> findAllByCanceledIsNotNull();

    List<PurchaseOrder> findAllByCanceledIsNullAndFinishedIsNull();



}
