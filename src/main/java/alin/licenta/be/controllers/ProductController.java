package alin.licenta.be.controllers;

import alin.licenta.be.dto.ProductDTO;
import alin.licenta.be.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody ProductDTO productEntryDTO) {
        return new ResponseEntity<>(productService.create(productEntryDTO), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> findById(@PathVariable Integer id) {
        return new ResponseEntity<>(productService.findDTOById(id), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ProductDTO>> findAll() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody ProductDTO productEntryDTO) {
        return new ResponseEntity<>(productService.update(id, productEntryDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Integer id) {
        productService.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Object> deleteAll() {
        productService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
