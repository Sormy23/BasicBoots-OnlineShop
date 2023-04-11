package at.ac.htlwrn.dao;

import at.ac.htlwrn.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@DataJpaTest
public class ProductDaoTest {

    @Autowired
    private ProductDao productDao;

    private Product saveProduct(String name, String desc, double preis, String img) {
        Product pr = new Product();
        pr.setName(name);
        pr.setDesc(desc);
        pr.setPrice(preis);
        pr.setImg(img);
        return productDao.save(pr);
    }

    @Test
    public void testFindByName() {
        String name = "Boots";
        String desc = "die sind sooo toll";
        double price = 17.99;
        String img = "C://sven/blabla";

        saveProduct(name, desc, price, img);

        Optional<Product> product = productDao.findByName(name);
        Assertions.assertTrue(product.isPresent());
        Assertions.assertEquals(desc, product.get().getDesc());
        Assertions.assertEquals(price, product.get().getPrice());
        Assertions.assertEquals(img, product.get().getImg());
    }

    @Test
    public void findByID() {
        String name = "Boots";
        String desc = "die sind sooo toll";
        double price = 17.99;
        String img = "C://sven/blabla";

        Product savedProduct = saveProduct(name, desc, price, img);

        Optional<Product> product = productDao.findById(savedProduct.getId());
        Assertions.assertTrue(product.isPresent());
        Assertions.assertEquals(product.get().getId(), savedProduct.getId());
        Assertions.assertEquals(desc, product.get().getDesc());
        Assertions.assertEquals(price, product.get().getPrice());
        Assertions.assertEquals(img, product.get().getImg());
    }

    @Test
    public void testFindAllByGueltigAbBeforeAndGueltigBisAfter() {
        String name = "Boots";
        String desc = "die sind sooo toll";
        double price = 17.99;
        String img = "C://sven/blabla";
        Date bis = new Date("04/11/2023");
        Date von = new Date("04/11/2020");

        Product pr = new Product();
        pr.setName(name);
        pr.setDesc(desc);
        pr.setPrice(price);
        pr.setImg(img);
        pr.setGueltigAb(von);
        pr.setGueltigBis(bis);
        productDao.save(pr);

        List<Product> product = productDao.findAllByGueltigAbBeforeAndGueltigBisAfter(new Date("06/01/2021"), new Date("06/01/2021"));
        Assertions.assertFalse(product.isEmpty());
    }
}
