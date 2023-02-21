package at.ac.htlwrn.dao;


import at.ac.htlwrn.model.PurchaseOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.sql.Timestamp;


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
}
