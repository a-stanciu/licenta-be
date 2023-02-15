package alin.licenta.be.controllers;

import alin.licenta.be.dto.UserDTO;
import alin.licenta.be.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody UserDTO userEntryDTO) {
        return new ResponseEntity<>(userService.create(userEntryDTO), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> findById(@PathVariable Integer id) {
        return new ResponseEntity<>(userService.findDTOById(id), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserDTO>> findAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody UserDTO userEntryDTO) {
        return new ResponseEntity<>(userService.update(id, userEntryDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Integer id) {
        userService.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Object> deleteAll() {
        userService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
