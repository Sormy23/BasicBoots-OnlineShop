package at.ac.htlwrn.service.impl;

import at.ac.htlwrn.dto.ProductDto;
import at.ac.htlwrn.dto.PurchaseOrderDto;
import at.ac.htlwrn.model.Product;
import at.ac.htlwrn.model.PurchaseOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AutoConfigureTestDatabase
@SpringBootTest
public class PurchaseOrderServiceImplTest {
    @Autowired
    private PurchaseOrderServiceImpl purchaseOrderService;

    private PurchaseOrder createOrder(String anrede, String name, String street, String zipCode, String city, Date date, Double price) {
        PurchaseOrderDto order = new PurchaseOrderDto();
        order.setAnrede(anrede);
        order.setName(name);
        order.setStreet(street);
        order.setZipCode(zipCode);
        order.setCity(city);
        order.setDate(date);
        order.setPrice(price);

        return purchaseOrderService.save(order);
    }

    @Test
    public void testCanceledAndFind() {
        String anrede = "Müller";
        String name = "Meier";
        String street = "Straße 1";
        String zipCode = "2700";
        String city = "Wiener Neustadt";
        Date now = new Date();
        Double price = 17.99;

        PurchaseOrder order = createOrder(anrede, name, street, zipCode, city, now, price);

        purchaseOrderService.cancel(order.getId());

        Optional<PurchaseOrder> canceledOrder = purchaseOrderService.find(true, false)
                .stream().filter(u -> u.getId().equals(order.getId())).findFirst();

        Assertions.assertTrue(canceledOrder.isPresent());
        Assertions.assertNotNull(canceledOrder.get().getCanceled());
        Assertions.assertNull(canceledOrder.get().getFinished());
    }

    @Test
    public void testFinished() {
        String anrede = "Frau";
        String name = "Memet";
        String street = "Straße 1";
        String zipCode = "2700";
        String city = "Wiener Neustadt";
        Date now = new Date();
        Double price = 17.99;

        PurchaseOrder order = createOrder(anrede, name, street, zipCode, city, now, price);

        purchaseOrderService.finish(order.getId());

        Optional<PurchaseOrder> finishedOrder = purchaseOrderService.find(false, true)
                .stream().filter(u -> u.getId().equals(order.getId())).findFirst();

        Assertions.assertTrue(finishedOrder.isPresent());
        Assertions.assertNull(finishedOrder.get().getCanceled());
        Assertions.assertNotNull(finishedOrder.get().getFinished());
    }

    @Test
    public void testFind() {
        String anrede = "Herr";
        String name = "Sahin";
        String street = "Straße 1";
        String zipCode = "2700";
        String city = "Wiener Neustadt";
        Date now = new Date();
        Double price = 17.99;

        PurchaseOrder order = createOrder(anrede, name, street, zipCode, city, now, price);

        Optional<PurchaseOrder> foundProduct = purchaseOrderService.find(false, false).stream()
                .filter(u -> u.getId().equals(order.getId())).findFirst();

        Assertions.assertTrue(foundProduct.isPresent());
    }

}
