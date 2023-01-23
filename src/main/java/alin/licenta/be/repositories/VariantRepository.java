package alin.licenta.be.repositories;

import alin.licenta.be.entities.Variant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VariantRepository extends JpaRepository<Variant, Integer> {
}
