package at.ac.htlwrn.service.impl;

import at.ac.htlwrn.dto.PurchaseOrderDto;
import at.ac.htlwrn.model.PurchaseOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

@AutoConfigureTestDatabase
@SpringBootTest
public class PurchaseOrderServiceImplTest {
    @Autowired
    private PurchaseOrderServiceImpl purchaseOrderService;

    private PurchaseOrder createOrder(String anrede, String name, String street, String zipCode, String city, Date date) {
        PurchaseOrderDto order = new PurchaseOrderDto();
        order.setAnrede(anrede);
        order.setName(name);
        order.setStreet(street);
        order.setZipCode(zipCode);
        order.setCity(city);
        order.setDate(date);

        return purchaseOrderService.save(order);
    }

    @Test
    public void testCanceled() {
        String anrede = "Müller";
        String name = "Meier";
        String street = "Straße 1";
        String zipCode = "2700";
        String city = "Wiener Neustadt";
        Date now = new Date();

    }

}
