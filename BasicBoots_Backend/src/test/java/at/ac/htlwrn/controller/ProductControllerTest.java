package at.ac.htlwrn.controller;

import at.ac.htlwrn.dto.ProductDto;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import java.util.Date;

@AutoConfigureTestDatabase
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {

    @LocalServerPort
    private int port;

    //TODO: Test for products fail because of the missing authentication

    @Test
    public void whenPostOnSaveReturnOK() {
        ProductDto product = new ProductDto();
        product.setName("Schuhe");
        product.setDesc("ein schuhsch");
        product.setImg("C://test/");
        product.setPrice(19.99);
        product.setGueltigAb(new Date());
        product.setGueltigBis(new Date());

        given().port(port).when()
                .contentType("application/json")
                .body(product)
                .post("/product")
                .then().statusCode(200)
                .assertThat()
                .body("message", equalTo("Product saved successfully."));
    }

    @Test
    public void whenGetOnAllProductsReturnOK() {
        given().port(port).when()
                .contentType("application/json")
                .get("/product")
                .then().statusCode(200)
                .assertThat()
                .body("message", equalTo("Product list fetched successfully."));
    }

    @Test
    public void whenGetByIDsReturnOK() {
        given().port(port).when()
                .contentType("application/json")
                .get("/product/1")
                .then().statusCode(200)
                .assertThat()
                .body("message", equalTo("Product fetched successfully."))
                .body("result", notNullValue());
    }

    @Test
    public void whenGetWithSearchReturnOK() {
        given().port(port).when()
                .contentType("application/json")
                .get("/product/search/Schuh")
                .then().statusCode(200)
                .assertThat()
                .body("message", equalTo("Product fetched successfully."));
    }

    @Test
    public void whenPutWithUpdateReturnOK() {
        ProductDto product = new ProductDto();
        product.setId(1L);
        product.setName("Gute Schuhe");
        product.setDesc("ein schuhsch");
        product.setImg("C://test/testst/");
        product.setPrice(19.99);
        product.setGueltigAb(new Date());
        product.setGueltigBis(new Date());


        given().port(port).when()
                .contentType("application/json")
                .body(product)
                .put("/product/update")
                .then().statusCode(200)
                .assertThat()
                .body("message", equalTo("Product updated successfully."));
    }

    @Test
    public void whenPutWithDeactivateReturnOK() {
        given().port(port).when()
                .contentType("application/json")
                .put("/product/deactivate/1")
                .then().statusCode(200)
                .assertThat()
                .body("message", equalTo("Product deactivated successfully"));
    }

}
