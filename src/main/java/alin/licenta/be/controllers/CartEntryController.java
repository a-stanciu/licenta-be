package alin.licenta.be.controllers;

import alin.licenta.be.dto.CartEntryDTO;
import alin.licenta.be.services.CartEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartEntry")
public class CartEntryController {

    CartEntryService cartEntryService;

    @Autowired
    public CartEntryController(CartEntryService cartEntryService) {
        this.cartEntryService = cartEntryService;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody CartEntryDTO cartEntryDTO) {
        return new ResponseEntity<>(cartEntryService.create(cartEntryDTO), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> findById(@PathVariable Integer id) {
        return new ResponseEntity<>(cartEntryService.findDTOById(id), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CartEntryDTO>> findAll() {
        return new ResponseEntity<>(cartEntryService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody CartEntryDTO cartEntryDTO) {
        return new ResponseEntity<>(cartEntryService.update(id, cartEntryDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Integer id) {
        cartEntryService.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Object> deleteAll() {
        cartEntryService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
