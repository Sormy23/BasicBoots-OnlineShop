package at.ac.htlwrn.controller;

import at.ac.htlwrn.dto.ProductDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import java.util.Date;

@AutoConfigureTestDatabase
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {

    @LocalServerPort
    private int port;

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

}
