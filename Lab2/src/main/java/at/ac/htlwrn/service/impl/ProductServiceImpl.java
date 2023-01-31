package at.ac.htlwrn.service.impl;

import at.ac.htlwrn.dto.ProductDto;
import at.ac.htlwrn.model.Product;
import at.ac.htlwrn.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Override
    public Product save(ProductDto product) {
        return null;
    }

    @Override
    public void update(ProductDto product) {
    }

    @Override
    public void deactivate(Long id) {

    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public List<Product> search(String searchString) {
        return null;
    }
}
