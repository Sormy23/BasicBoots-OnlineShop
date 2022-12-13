package at.ac.htlwrn.dao;

import at.ac.htlwrn.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ProductDao extends CrudRepository<Product, Long> {

}
