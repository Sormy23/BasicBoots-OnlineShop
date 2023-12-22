package at.ac.htlwrn.service.impl;

import at.ac.htlwrn.dao.ProductDao;
import at.ac.htlwrn.model.Product;
import at.ac.htlwrn.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AutoConfigureTestDatabase
@SpringBootTest
public class ProductServiceMockTest {

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductDao productDao;

    @Test
    public void testGetAllProducts() {
        List<Product> mockProducts = new ArrayList<>();

        mockProducts.add(new Product() {
            {
                setName("TestProduct1");
                setPrice(1.0);
                setDesc("TestDesc1");
                setImg("TestImg1");
            }
        });

        mockProducts.add(new Product() {
            {
                setName("TestProduct2");
                setPrice(2.0);
                setDesc("TestDesc2");
                setImg("TestImg2");
            }
        });

        mockProducts.add(new Product() {
            {
                setName("TestProduct3");
                setPrice(3.0);
                setDesc("TestDesc3");
                setImg("TestImg3");
            }
        });

        Mockito.when(productDao.findAll())
                .thenReturn(mockProducts);

        Iterable<Product> foundProducts = productService.findAll();
        Assertions.assertNotNull(foundProducts);
    }
}
