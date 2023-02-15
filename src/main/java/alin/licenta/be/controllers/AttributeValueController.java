package alin.licenta.be.controllers;

import alin.licenta.be.dto.AttributeValueDTO;
import alin.licenta.be.services.AttributeValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attributeValue")
public class AttributeValueController {

    AttributeValueService attributeValueService;

    @Autowired
    public AttributeValueController(AttributeValueService attributeValueService) {
        this.attributeValueService = attributeValueService;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody AttributeValueDTO attributeValueDTO) {
        return new ResponseEntity<>(attributeValueService.create(attributeValueDTO), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> findById(@PathVariable Integer id) {
        return new ResponseEntity<>(attributeValueService.findDTOById(id), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AttributeValueDTO>> findAll() {
        return new ResponseEntity<>(attributeValueService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody AttributeValueDTO attributeValueDTO) {
        return new ResponseEntity<>(attributeValueService.update(id, attributeValueDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Integer id) {
        attributeValueService.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Object> deleteAll() {
        attributeValueService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
