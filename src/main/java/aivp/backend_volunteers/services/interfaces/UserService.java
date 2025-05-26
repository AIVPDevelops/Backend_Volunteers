package aivp.backend_volunteers.services.interfaces;

import aivp.backend_volunteers.entities.UserEntity;
import aivp.backend_volunteers.models.users.UserResponseDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserEntity> findAll();

    Optional<UserEntity> findByEmail(String email);

    UserResponseDto transformResponse(UserEntity user);

    UserEntity save(UserEntity user);
}
