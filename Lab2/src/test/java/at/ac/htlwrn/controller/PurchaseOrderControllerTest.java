package at.ac.htlwrn.controller;

import at.ac.htlwrn.dto.ProductDto;
import at.ac.htlwrn.dto.PurchaseOrderDto;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.data.domain.jaxb.SpringDataJaxb;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import java.util.Date;

@AutoConfigureTestDatabase
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PurchaseOrderControllerTest {

    @LocalServerPort
    private int port;

    //TODO: Test for ordres fail because of the missing authentication

    @Test
    public void whenPostOnSaveOrderReturnOK() {
        PurchaseOrderDto order = new PurchaseOrderDto();
        order.setAnrede("Frau");
        order.setName("Meier");
        order.setStreet("Gasssse");
        order.setZipCode("3700");
        order.setCity("Joa");
        order.setDate(new Date());
        order.setPrice(27.99);

        given().port(port).when()
                .contentType("application/json")
                .body(order)
                .post("/order")
                .then().statusCode(200)
                .assertThat()
                .body("message", equalTo("Order saved successfully."));
    }

    @Test
    public void whenGetOnAllValidOrdersReturnOK() {
        given().port(port).when()
                .contentType("application/json")
                .get("/order")
                .then().statusCode(200)
                .assertThat()
                .body("message", equalTo("Product list fetched successfully."));
    }

    @Test
    public void whenGetByIDsReturnOK() {
        given().port(port).when()
                .contentType("application/json")
                .get("/order/1")
                .then().statusCode(200)
                .assertThat()
                .body("message", equalTo("Order fetched successfully."))
                .body("result", notNullValue());
    }

    @Test
    public void whenPutCancelReturnOK() {
        given().port(port).when()
                .contentType("application/json")
                .put("/order/cancel/1")
                .then().statusCode(200)
                .assertThat()
                .body("message", equalTo("Order canceled successfully."));
    }

    @Test
    public void whenPutFinishReturnOK() {
        given().port(port).when()
                .contentType("application/json")
                .put("/order/finish/2")
                .then().statusCode(200)
                .assertThat()
                .body("message", equalTo("Order finished successfully."));
    }

}
