package at.ac.htlwrn.service.impl;

import at.ac.htlwrn.dto.ProductDto;
import at.ac.htlwrn.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Optional;

@AutoConfigureTestDatabase
@SpringBootTest
public class ProductServiceImplTest {
    @Autowired
    private ProductServiceImpl productService;

    private Product createProduct(String name, String desc, double price, String img, Date gueltigAb, Date gueltigBis) {
        ProductDto product = new ProductDto();
        product.setName(name);
        product.setDesc(desc);
        product.setImg(img);
        product.setPrice(price);
        product.setGueltigAb(gueltigAb);
        product.setGueltigBis(gueltigBis);
        return productService.save(product);
    }

    @Test
    public void testSave() {
        String name = "Book";
        String desc = "heheheah";
        double price = 99.99;
        String img = "./resources/img/office.png";
        Date gueltigAb = new Date("01/01/2000");
        Date gueltigBis = new Date("01/01/2030");
        createProduct(name, desc, price, img, gueltigAb, gueltigBis);

        Optional<Product> foundProduct = productService.findAll().stream().filter(u -> u.getName().equals(name)).findFirst();
        Assertions.assertTrue(foundProduct.isPresent());
        Assertions.assertEquals(name, foundProduct.get().getName());
        Assertions.assertEquals(desc, foundProduct.get().getDesc());
        Assertions.assertEquals(price, foundProduct.get().getPrice());
        Assertions.assertEquals(img, foundProduct.get().getImg());
    }

    @Test
    public void testSearch() {
        String name = "KANASIMIARU";
        String desc = "heheheah";
        double price = 99.99;
        String img = "./resources/img/office.png";
        Date gueltigAb = new Date("01/01/2000");
        Date gueltigBis = new Date("01/01/2030");
        createProduct(name, desc, price, img, gueltigAb, gueltigBis);

        Optional<Product> foundProduct = productService.search("kana").stream().filter(u -> u.getName().equals(name)).findFirst();
        Assertions.assertTrue(foundProduct.isPresent());
        Assertions.assertEquals(name, foundProduct.get().getName());
        Assertions.assertEquals(desc, foundProduct.get().getDesc());
        Assertions.assertEquals(price, foundProduct.get().getPrice());
        Assertions.assertEquals(img, foundProduct.get().getImg());
    }

    @Test
    public void testDeactivate() {
        String name = "deactivateme";
        String desc = "heheheah";
        double price = 99.99;
        String img = "./resources/img/office.png";
        Date gueltigAb = new Date("01/01/2000");
        Date gueltigBis = new Date("01/01/2030");
        Product savedProduct = createProduct(name, desc, price, img, gueltigAb, gueltigBis);

        productService.deactivate(savedProduct.getId());

        Optional<Product> foundProduct = productService.findAll().stream().filter(p -> p.getId().equals(savedProduct.getId())).findFirst();
        Assertions.assertFalse(foundProduct.isPresent());
    }

    @Test
    public void testUpdate() {
        String name = "updateme";
        String desc = "heheheah";
        double price = 99.99;
        String img = "./resources/img/office.png";
        Date gueltigAb = new Date("01/01/2000");
        Date gueltigBis = new Date("01/01/2030");
        Product savedProduct = createProduct(name, desc, price, img, gueltigAb, gueltigBis);

        //update the product

        String uName = "updatedProduct";

        ProductDto newProduct = new ProductDto();
        newProduct.setName(uName);
        newProduct.setDesc(desc);
        newProduct.setImg(img);
        newProduct.setPrice(price);
        newProduct.setGueltigAb(gueltigAb);
        newProduct.setGueltigBis(gueltigBis);
        newProduct.setId(savedProduct.getId());

        productService.update(newProduct);

        Optional<Product> foundProduct = productService.findAll().stream().filter(p -> p.getId().equals(savedProduct.getId())).findFirst();
        Assertions.assertTrue(foundProduct.isPresent());
        Assertions.assertEquals(uName, foundProduct.get().getName());
        Assertions.assertEquals(desc, foundProduct.get().getDesc());
        Assertions.assertEquals(price, foundProduct.get().getPrice());
        Assertions.assertEquals(img, foundProduct.get().getImg());
    }

    /*
    Sowohl findByName als auch findById wurden indirekt bei den anderen Test mitgetestet
     */
}
