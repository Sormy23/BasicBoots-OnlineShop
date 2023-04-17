package at.ac.htlwrn.service.impl;

import at.ac.htlwrn.dto.ProductDto;
import at.ac.htlwrn.exception.UserAlredyExistsException;
import at.ac.htlwrn.model.Product;
import at.ac.htlwrn.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@AutoConfigureTestDatabase
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductService productService;

    private void createProduct(String name, String desc, double preis, String img) {
        ProductDto pr = new ProductDto();
        pr.setName(name);
        pr.setDesc(desc);
        pr.setPrice(preis);
        pr.setImg(img);
        productService.save(pr);
    }

    @Test
    public void testSave() { //TODO: Test failed
        String name = "Boots";
        String desc = "die sind sooo toll";
        double price = 17.99;
        String img = "C://sven/blabla";
        createProduct(name, desc, price, img);

        Optional<Product> foundProduct = productService.findAll().stream().filter(u -> u.getName().equals(name)).findFirst();
        Assertions.assertTrue(foundProduct.isPresent());
        Assertions.assertEquals(name, foundProduct.get().getName());
        Assertions.assertEquals(desc, foundProduct.get().getDesc());
        Assertions.assertEquals(price, foundProduct.get().getPrice());
        Assertions.assertEquals(img, foundProduct.get().getImg());
    }

    @Test
    public void testSaveTwice() {
        String name = "Filip-Flops";
        String desc = "hehehheheheha";
        double price = 2730.99;
        String img = "C://sven/filipiflopipi";
        createProduct(name, desc, price, img);
        try {
            createProduct(name, desc, price, img);
            Assertions.fail();
        } catch (UserAlredyExistsException ex) {
            Assertions.assertEquals("Product already exists!", ex.getMessage());
        }
    }

}
