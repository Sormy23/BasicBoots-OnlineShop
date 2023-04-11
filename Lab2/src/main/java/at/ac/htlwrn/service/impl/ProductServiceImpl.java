package at.ac.htlwrn.service.impl;

import at.ac.htlwrn.dao.ProductDao;
import at.ac.htlwrn.dto.ProductDto;
import at.ac.htlwrn.exception.ProductAlreadyExistsException;
import at.ac.htlwrn.exception.ProductNotFoundException;
import at.ac.htlwrn.model.Product;
import at.ac.htlwrn.service.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.*;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "productService")
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
        newProduct.setGueltigAb(product.getGueltig_ab());
        newProduct.setGueltigBis(product.getGueltig_bis());

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
        logger.info("Deactivate id: {}", id);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);

        Optional<Product> productOpt = productDao.findById(id);
        Product product = productOpt.orElseThrow(ProductNotFoundException::new);
        product.setGueltigBis(cal.getTime());
        productDao.save(product);
    }

    @Override
    public List<Product> findAll() {
        logger.info("Search for all valid products!");

        Date now = new Date();
        return new ArrayList<Product>(productDao.findAllByGueltigAbBeforeAndGueltigBisAfter(now, now));
    }

    @Override
    public List<Product> search(String searchString) {
        Validate.notNull(searchString);
        logger.info("Find Product by SearchString: {}", searchString);

        Date now = new Date();
        List<Product> productList = new ArrayList<>(productDao.findAllByGueltigAbBeforeAndGueltigBisAfter(now, now));

        for (int i = 0; i < productList.size(); i++) {
            if (!productList.get(i).getName().contains(searchString)) {
                productList.remove(i);
            }
        }
        return productList;
    }
}
