package aivp.backend_volunteers.services.implementations;

import aivp.backend_volunteers.entities.RoleEntity;
import aivp.backend_volunteers.models.exceptions.DatabaseException;
import aivp.backend_volunteers.repositories.RoleRepository;
import aivp.backend_volunteers.repositories.UserRepository;
import aivp.backend_volunteers.services.interfaces.RoleService;
import aivp.backend_volunteers.utils.Constants;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;
    @Override
    public Optional<RoleEntity> findById(Long id) {
        try {
            return repository.findById(id);
        } catch (Exception e) {
            throw new DatabaseException(Constants.MESSAGE_INTERNAL_DATABASE_ERROR, e);
        }
    }
}
