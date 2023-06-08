package alin.licenta.be.controllers;

import alin.licenta.be.dto.VariantDTO;
import alin.licenta.be.services.VariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/variant")
@CrossOrigin
public class VariantController {

    final VariantService variantService;

    @Autowired
    public VariantController(VariantService variantService) {
        this.variantService = variantService;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody VariantDTO variantEntryDTO) {
        return new ResponseEntity<>(variantService.create(variantEntryDTO), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> findById(@PathVariable Integer id) {
        return new ResponseEntity<>(variantService.findDTOById(id), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<VariantDTO>> findAll() {
        return new ResponseEntity<>(variantService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody VariantDTO variantEntryDTO) {
        return new ResponseEntity<>(variantService.update(id, variantEntryDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Integer id) {
        variantService.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Object> deleteAll() {
        variantService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
