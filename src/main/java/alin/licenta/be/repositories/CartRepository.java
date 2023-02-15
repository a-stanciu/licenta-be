package alin.licenta.be.repositories;

import alin.licenta.be.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    List<Cart> findByUser(int userId);


    Cart findCurrentByUser(int userId);
}
