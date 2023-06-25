package alin.licenta.be.controllers;

import alin.licenta.be.dto.CartDTO;
import alin.licenta.be.services.CartService;
import alin.licenta.be.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/cart")
@CrossOrigin
public class CartController {

    final CartService cartService;

    final UserService userService;

    @Autowired
    public CartController(CartService cartService, UserService userService) {
        this.cartService = cartService;
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody CartDTO cartDTO) {
        return new ResponseEntity<>(cartService.create(cartDTO), HttpStatus.OK);
    }

    @PostMapping("/placeOrder")
    public ResponseEntity<Object> placeOrder(@RequestBody CartDTO cartDTO) {
        return new ResponseEntity<>(cartService.placeOrder(cartDTO), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> findById(@PathVariable Integer id) {
        return new ResponseEntity<>(cartService.findDTOById(id), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CartDTO>> findAll() {
        return new ResponseEntity<>(cartService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getByUser/{id}")
    public ResponseEntity<List<CartDTO>> findCartHistory(@PathVariable Integer id) {
        return new ResponseEntity<>(cartService.findByUser(id), HttpStatus.OK);
    }

    @GetMapping("/getCurrentByUser/{id}")
    public ResponseEntity<Object> findCurrentByUser(@PathVariable Integer id) {
        return new ResponseEntity<>(cartService.findCurrentByUser(id), HttpStatus.OK);
    }

    @GetMapping("/getCurrent")
    public ResponseEntity<Object> findCurrent(Principal principal) {
        return new ResponseEntity<>(cartService.findCurrentByUser(userService.loadUserByUsername(principal.getName()).getId()), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody CartDTO cartDTO) {
        return new ResponseEntity<>(cartService.update(id, cartDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Integer id) {
        cartService.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Object> deleteAll() {
        cartService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
