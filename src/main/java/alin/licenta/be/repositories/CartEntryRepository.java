package alin.licenta.be.repositories;

import alin.licenta.be.entities.CartEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartEntryRepository extends JpaRepository<CartEntry, Integer> {
}
