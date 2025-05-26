package aivp.backend_volunteers.services.interfaces;

import aivp.backend_volunteers.entities.RoleEntity;

import java.util.Optional;

public interface RoleService {
    Optional<RoleEntity> findById (Long id);
}
