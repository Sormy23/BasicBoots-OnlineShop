package at.ac.htlwrn.dao;


import at.ac.htlwrn.model.Product;
import at.ac.htlwrn.model.PurchaseOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.sql.Timestamp;
import java.util.Optional;


@DataJpaTest
public class PurchaseOrderDaoTest {

    @Autowired
    private PurchaseOrderDao purchaseOrderDao;

    private PurchaseOrder saveOrder(String anrede, String vorname, String name, String street, String zipCode, String city, Timestamp date, double price) {
        PurchaseOrder pr = new PurchaseOrder();
        pr.setAnrede(anrede);
        pr.setVorname(vorname);
        pr.setName(name);
        pr.setStreet(street);
        pr.setZipCode(zipCode);
        pr.setCity(city);
        pr.setDate(date);
        pr.setPrice(price);
        return purchaseOrderDao.save(pr);
    }

    @Test
    public void testFindByName() {
        String anrede = "Herr";
        String vorname = "Sven";
        String name = "Oberwalder";
        String street = "Straße 1";
        String zipCode = "2700";
        String city = "Wiener Neustadt";
        Timestamp date = new Timestamp(System.currentTimeMillis());
        double price = 17.99;

        saveOrder(anrede, vorname, name, street, zipCode, city, date, price);

        Optional<PurchaseOrder> order = purchaseOrderDao.findByName(name);
        Assertions.assertTrue(order.isPresent());
        Assertions.assertEquals(price, order.get().getPrice());
        Assertions.assertEquals(city, order.get().getCity());
    }

    @Test
    public void testFindByName_UnknownName() {
        Optional<PurchaseOrder> order = purchaseOrderDao.findByName("heheheeha");
        Assertions.assertFalse(order.isPresent());
    }

    @Test
    public void testDeleteOrder() {
        String anrede = "Müller";
        String vorname = "Sven";
        String name = "Meier";
        String street = "Straße 1";
        String zipCode = "2700";
        String city = "Wiener Neustadt";
        Timestamp date = new Timestamp(System.currentTimeMillis());
        double price = 17.99;

        saveOrder(anrede, vorname, name, street, zipCode, city, date, price);

        Optional<PurchaseOrder> order = purchaseOrderDao.findByName(name);
        Assertions.assertTrue(order.isPresent());

        purchaseOrderDao.delete(order.get());

        order = purchaseOrderDao.findByName(name);
        Assertions.assertFalse(order.isPresent());
    }

    @Test
    public void findByID() {
        String anrede = "Müller";
        String vorname = "Sven";
        String name = "Meier";
        String street = "Straße 1";
        String zipCode = "2700";
        String city = "Wiener Neustadt";
        Timestamp date = new Timestamp(System.currentTimeMillis());
        double price = 17.99;

        PurchaseOrder purchaseOrder = saveOrder(anrede, vorname, name, street, zipCode, city, date, price);

        Optional<PurchaseOrder> order = purchaseOrderDao.findById(purchaseOrder.getId());
        Assertions.assertTrue(order.isPresent());
        Assertions.assertEquals(price, order.get().getPrice());
        Assertions.assertEquals(city, order.get().getCity());
    }
}
