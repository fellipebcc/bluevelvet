package com.musicstore.bluevelvet.api.controller;

import com.musicstore.bluevelvet.api.request.ProductRequest;
import com.musicstore.bluevelvet.api.response.ProductResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/{id}")
    @Operation(summary = "Fetch product by id", description = "Fetch a product from the Blue Velvet Music Store")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Long id) {
        log.info("Request received to fetch a product by id {}", id);

        // FIXME: Remove mock
        return ResponseEntity.ok(assembleProductResponseMock(id));
    }

    // TODO: Add pageable from spring data
    @GetMapping
    @Operation(summary = "Get all products", description = "Get all products from the Blue Velvet Music Store")
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        log.info("Request received to fetch all products");

        // FIXME: Remove mock
        return ResponseEntity.ok(List.of(
                assembleProductResponseMock(1L),
                assembleProductResponseMock(2L),
                assembleProductResponseMock(3L)
        ));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete product by id", description = "Delete a product from the Blue Velvet Music Store")
    public ResponseEntity<Void> deleteProductById(@PathVariable Long id) {
        log.info("Request received to delete a product by id {}", id);

        return ResponseEntity.ok(null);
    }

    @PostMapping
    @Operation(summary = "Create a new product", description = "Create a product for the Blue Velvet Music Store")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest request){
        log.info("Request received to create a new product. The request is {}", request);

        return ResponseEntity.ok(assembleProductResponseMock(7L));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a product", description = "Update a product from the Blue Velvet Music Store")
    public ResponseEntity<ProductResponse> updateProductById(@PathVariable Long id, @RequestBody ProductRequest request) {
        log.info("Request received to update the product with id {} with the request {}", id, request);

        return ResponseEntity.ok(assembleProductResponseMock(id));
    }

    // TODO: Remove it after conclude the service and repository
    private static ProductResponse assembleProductResponseMock(Long id) {
        return ProductResponse.builder()
                .id(id)
                .name("CD player")
                .brand("Elgin")
                .build();
    }

}
