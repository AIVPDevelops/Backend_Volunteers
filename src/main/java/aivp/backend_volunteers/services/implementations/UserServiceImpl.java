package aivp.backend_volunteers.services.implementations;

import aivp.backend_volunteers.entities.UserEntity;
import aivp.backend_volunteers.models.exceptions.DatabaseException;
import aivp.backend_volunteers.models.users.UserResponseDto;
import aivp.backend_volunteers.repositories.UserRepository;
import aivp.backend_volunteers.services.interfaces.UserService;
import aivp.backend_volunteers.utils.Constants;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public List<UserEntity> findAll() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new DatabaseException(Constants.MESSAGE_INTERNAL_DATABASE_ERROR, e);
        }
    }

    @Override
    public Optional<UserEntity> findByEmail(String email) {
        try {
            return repository.findByEmail(email);
        } catch (Exception e) {
            throw new DatabaseException(Constants.MESSAGE_INTERNAL_DATABASE_ERROR, e);
        }
    }

    @Override
    public UserResponseDto transformResponse(UserEntity user) {
        return UserResponseDto.builder()
                .fullName(user.getFullName())
                .email(user.getEmail())
                .enabled(user.getEnabled())
                .role(user.getRole().getName()).build();
    }
    @Override
    public UserEntity save(UserEntity user) {
        try {
            return repository.save(user);
        } catch (Exception e) {
            throw new DatabaseException(Constants.MESSAGE_INTERNAL_DATABASE_ERROR, e);
        }
    }
}
