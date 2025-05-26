package aivp.backend_volunteers.repositories;

import aivp.backend_volunteers.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
}
