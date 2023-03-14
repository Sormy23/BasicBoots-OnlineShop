package at.ac.htlwrn.service.impl;

import at.ac.htlwrn.dao.ProductDao;
import at.ac.htlwrn.dto.ProductDto;
import at.ac.htlwrn.exception.ProductAlreadyExistsException;
import at.ac.htlwrn.model.Product;
import at.ac.htlwrn.service.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;


@Service(value = "prudctService")
public class ProductServiceImpl implements ProductService {

    private static Logger logger = LogManager.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductDao productDao;

    @Override
    public Product save(ProductDto product) {
        Validate.notNull(product);
        Validate.notNull(product.getId(), "productDto.id must not be null");

        logger.info("Saving Product {}", product.getName());

        Optional<Product> prod = productDao.findByName(product.getName());
        if(prod.isPresent()) {
            logger.warn("User {} already exists", product.getName());
            throw new ProductAlreadyExistsException("Product already exists!");
        }

        Product newProduct = new Product();
        newProduct.setImg(product.getImg());
        newProduct.setDesc(product.getDesc());
        newProduct.setName(product.getName());
        newProduct.setPrice(product.getPrice());
        newProduct.setGueltig_ab(product.getGueltig_ab());
        newProduct.setGueltig_bis(product.getGueltig_bis());

        return productDao.save(newProduct);
    }

    @Override
    public Product findById(Long id) {
        Validate.notNull(id, "id must not be null");
        logger.debug("Find product by id {}", id);
        Optional<Product> product = productDao.findById(id);
        return product.orElse(null);
    }

    @Override
    public ProductDto update(ProductDto product) {
        Validate.notNull(product);
        Validate.notNull(product.getId(), "productDto.id must not be null");

        logger.info("Update Product {}", product.getId());
        Product prod = findById(product.getId());
        if(prod != null) {
            BeanUtils.copyProperties(product, prod);
            productDao.save(prod);
        }
        return product;
    }

    @Override
    public void deactivate(Long id) {
        logger.info("Deactivate Produt {}", id);
        Product product = findById(id); //id gets validated here

        if (product != null) {
            Date date = new Date();
            date.setDate(date.getDate() - 1);
            date.setHours(3);
            date.setMinutes(0);
            date.setSeconds(0);
            product.setGueltig_bis(date); // Datum auf gestern setzen
            productDao.save(product);
        }
    }

    @Override
    public List<Product> findAll() {
        logger.info("Search for all products!");
        return null;
    }

    @Override
    public List<Product> search(String searchString) {
        Validate.notNull(searchString);
        logger.info("Find Product by SearchString: {}", searchString);
        return null;
    }
}
