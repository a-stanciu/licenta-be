package alin.licenta.be.repositories;

import alin.licenta.be.entities.Cart;
import alin.licenta.be.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    List<Cart> findCartsByUser(User user);

    Cart findTop1CartByUserOrderByLastModifiedDesc(User user);
}
