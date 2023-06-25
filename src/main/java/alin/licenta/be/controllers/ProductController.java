package alin.licenta.be.controllers;

import alin.licenta.be.dto.ProductRequestDTO;
import alin.licenta.be.dto.ProductResponseDTO;
import alin.licenta.be.entities.Product;
import alin.licenta.be.services.ProductService;
import alin.licenta.be.services.VariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {

    final ProductService productService;

    final VariantService variantService;

    @Autowired
    public ProductController(ProductService productService, VariantService variantService) {
        this.productService = productService;
        this.variantService = variantService;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody ProductRequestDTO productDTO) {
        return new ResponseEntity<>(productService.create(productDTO), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> findById(@PathVariable Integer id) {
        return new ResponseEntity<>(productService.findDTOById(id), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ProductResponseDTO>> findAll() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getByVariant/{id}")
    public ResponseEntity<Product> findByVariant(@PathVariable Integer id) {
        return new ResponseEntity<>(productService.findEntityById(variantService.findEntityById(id).getProduct().getId()), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody ProductRequestDTO productDTO) {
        return new ResponseEntity<>(productService.update(id, productDTO), HttpStatus.OK);
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
