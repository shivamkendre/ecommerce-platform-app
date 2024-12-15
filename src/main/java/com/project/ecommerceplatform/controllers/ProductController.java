package com.project.ecommerceplatform.controllers;

import com.project.ecommerceplatform.exceptions.ProductNotFoundException;
import com.project.ecommerceplatform.models.Product;
import com.project.ecommerceplatform.services.FakeStoreApiProductService;
import com.project.ecommerceplatform.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ecom/product/")
public class ProductController {

    private final ProductService productService;
    private final FakeStoreApiProductService fakeStoreApiProductService;

    public ProductController(ProductService productService, FakeStoreApiProductService fakeStoreApiProductService) {
        this.productService = productService;
        this.fakeStoreApiProductService = fakeStoreApiProductService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") int id) throws ProductNotFoundException {
        Product product = productService.getProductWithId(id);
        ResponseEntity<Product> response = new ResponseEntity<>(product, HttpStatus.OK);
        return response;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() throws ProductNotFoundException {
        List<Product> productList = productService.getProducts();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") int id, @RequestBody Product product) throws ProductNotFoundException {
        product = fakeStoreApiProductService.updateProduct(id, product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> replaceProduct(@PathVariable("id") int id, @RequestBody Product product) throws ProductNotFoundException {
        product = fakeStoreApiProductService.replaceProduct(id, product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") int id) throws ProductNotFoundException {
        Product product = productService.deleteProduct(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

}
