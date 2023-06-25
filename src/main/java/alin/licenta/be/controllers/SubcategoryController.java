package alin.licenta.be.controllers;

import alin.licenta.be.dto.SubcategoryRequestDTO;
import alin.licenta.be.dto.SubcategoryResponseDTO;
import alin.licenta.be.services.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subcategory")
@CrossOrigin
public class SubcategoryController {

    final SubcategoryService subcategoryService;

    @Autowired
    public SubcategoryController(SubcategoryService subcategoryService) {
        this.subcategoryService = subcategoryService;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody SubcategoryRequestDTO subcategoryEntryDTO) {
        return new ResponseEntity<>(subcategoryService.create(subcategoryEntryDTO), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> findById(@PathVariable Integer id) {
        return new ResponseEntity<>(subcategoryService.findDTOById(id), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<SubcategoryResponseDTO>> findAll() {
        return new ResponseEntity<>(subcategoryService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody SubcategoryRequestDTO subcategoryEntryDTO) {
        return new ResponseEntity<>(subcategoryService.update(id, subcategoryEntryDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Integer id) {
        subcategoryService.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Object> deleteAll() {
        subcategoryService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

