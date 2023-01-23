package alin.licenta.be.repositories;

import alin.licenta.be.entities.Value;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValueRepository extends JpaRepository<Value, Integer> {
}
