package alin.licenta.be.controllers;

import alin.licenta.be.dto.AttributeDTO;
import alin.licenta.be.services.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attribute")
public class AttributeController {

    final AttributeService attributeService;

    @Autowired
    public AttributeController(AttributeService attributeService) {
        this.attributeService = attributeService;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody AttributeDTO attributeDTO) {
        return new ResponseEntity<>(attributeService.create(attributeDTO), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> findById(@PathVariable Integer id) {
        return new ResponseEntity<>(attributeService.findDTOById(id), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AttributeDTO>> findAll() {
        return new ResponseEntity<>(attributeService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody AttributeDTO attributeDTO) {
        return new ResponseEntity<>(attributeService.update(id, attributeDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Integer id) {
        attributeService.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Object> deleteAll() {
        attributeService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
