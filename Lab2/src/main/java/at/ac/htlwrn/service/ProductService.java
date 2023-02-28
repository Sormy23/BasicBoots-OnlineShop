package at.ac.htlwrn.service;

import at.ac.htlwrn.dto.ProductDto;
import at.ac.htlwrn.model.Product;

import java.util.List;

public interface ProductService {
    /**
     * Save new product
     * @param product {@link at.ac.htlwrn.dto.ProductDto} with product details
     * @return instance of {@link Product}
     */
    Product save(ProductDto product);

    /**
     * Updates a product
     * @param product of {@link Product} product data for update
     * @return product of {@link ProductDto}
     */

     ProductDto update(ProductDto product);

    /**
     * deactivates a product
     * @param id of {Long} id of product
     */
    void deactivate(Long id);

    /**
     * returns all Products
     * @return Returns a list of products
     */
    List<Product> findAll();

    /**
     * Searches products by the searchStrings
     * @param searchString string for search
     * @return List of {@link Product} if exists, else []
     */
    List<Product> search(String searchString);

    /**
     * finds a product by id
     * @param id id for search
     * @return Product of {@link Product} if exists, else null
     */
    public Product findById(Long id);
}
