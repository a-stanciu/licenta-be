package alin.licenta.be.controllers;

import alin.licenta.be.dto.ValueDTO;
import alin.licenta.be.services.ValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/value")
public class ValueController {

    ValueService valueService;

    @Autowired
    public ValueController(ValueService valueService) {
        this.valueService = valueService;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody ValueDTO valueEntryDTO) {
        return new ResponseEntity<>(valueService.create(valueEntryDTO), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> findById(@PathVariable Integer id) {
        return new ResponseEntity<>(valueService.findDTOById(id), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ValueDTO>> findAll() {
        return new ResponseEntity<>(valueService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody ValueDTO valueEntryDTO) {
        return new ResponseEntity<>(valueService.update(id, valueEntryDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Integer id) {
        valueService.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Object> deleteAll() {
        valueService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
