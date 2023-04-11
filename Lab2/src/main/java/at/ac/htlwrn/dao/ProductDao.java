package at.ac.htlwrn.dao;

import at.ac.htlwrn.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductDao extends CrudRepository<Product, Long> {

    List<Product> findByNameIsContainingIgnoreCase(String name);

    List<Product> findAllByGueltigAbBeforeAndGueltigBisAfter(Date now1, Date now2);

    Optional<Product> findByName(String name);
}
