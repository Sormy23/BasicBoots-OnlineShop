package at.ac.htlwrn.controller;

import at.ac.htlwrn.dto.ApiResponse;
import at.ac.htlwrn.dto.ProductDto;
import at.ac.htlwrn.dto.PurchaseOrderDto;
import at.ac.htlwrn.dto.UserDto;
import at.ac.htlwrn.model.Product;
import at.ac.htlwrn.model.PurchaseOrder;
import at.ac.htlwrn.model.User;
import at.ac.htlwrn.service.ProductService;
import at.ac.htlwrn.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/product")

public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ApiResponse<Product> saveProduct(@RequestBody ProductDto product){
        return new ApiResponse<>(HttpStatus.OK.value(), "Product saved successfully.", productService.save(product));
    }

    @GetMapping
    public ApiResponse<List<Product>> listProducts() {
        return new ApiResponse<>(HttpStatus.OK.value(), "Product list fetched successfully.", productService.findAll());
    }

    @GetMapping("/{id}")
    public ApiResponse<Product> getById(@PathVariable Long id){
        return new ApiResponse<>(HttpStatus.OK.value(), "Product fetched successfully.", productService.findById(id));
    }

    @GetMapping("/search/{search}")
    public ApiResponse<List<Product>> searchProduct(@PathVariable String search){
        return new ApiResponse<>(HttpStatus.OK.value(), "Product fetched successfully.", productService.search(search));
    }

    @PutMapping("/update")
    @Secured("ROLE_ADMIN")
    public ApiResponse<Product> updateProducts(@RequestBody ProductDto product) {
        return new ApiResponse<>(HttpStatus.OK.value(), "Product updated successfully.", productService.update(product));
    }

    @PutMapping("/deactivate/{id}")
    @Secured("ROLE_ADMIN")
    public ApiResponse<Void> deactivateProduct(@PathVariable Long id) {
        productService.deactivate(id);
        return new ApiResponse<>(HttpStatus.OK.value(), "Product deactivated successfully", null);
    }


}
