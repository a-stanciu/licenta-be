package alin.licenta.be.controllers;

import alin.licenta.be.dto.AssignedValueDTO;
import alin.licenta.be.services.AssignedValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignedValue")
@CrossOrigin
public class AssignedValueController {

    final AssignedValueService assignedValueService;

    @Autowired
    public AssignedValueController(AssignedValueService assignedValueService) {
        this.assignedValueService = assignedValueService;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody AssignedValueDTO assignedValueDTO) {
        return new ResponseEntity<>(assignedValueService.create(assignedValueDTO), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> findById(@PathVariable Integer id) {
        return new ResponseEntity<>(assignedValueService.findDTOById(id), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AssignedValueDTO>> findAll() {
        return new ResponseEntity<>(assignedValueService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody AssignedValueDTO assignedValueDTO) {
        return new ResponseEntity<>(assignedValueService.update(id, assignedValueDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Integer id) {
        assignedValueService.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Object> deleteAll() {
        assignedValueService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
