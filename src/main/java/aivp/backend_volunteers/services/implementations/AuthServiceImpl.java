package aivp.backend_volunteers.services.implementations;

import aivp.backend_volunteers.config.security.jwt.JwtUtils;
import aivp.backend_volunteers.entities.RoleEntity;
import aivp.backend_volunteers.entities.UserEntity;
import aivp.backend_volunteers.models.auth.AuthRequestDto;
import aivp.backend_volunteers.models.auth.AuthResponseDto;
import aivp.backend_volunteers.models.signup.SignUpRequestDto;
import aivp.backend_volunteers.services.interfaces.AuthService;
import aivp.backend_volunteers.services.interfaces.RoleService;
import aivp.backend_volunteers.services.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthResponseDto authenticate(AuthRequestDto request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String jwt = jwtUtils.generateToken(userDetails);

        return AuthResponseDto.builder().token(jwt).build();
    }

    @Override
    public String signUp(SignUpRequestDto request) {
        Optional<RoleEntity> role = roleService.findById(request.getRoleId());
        UserEntity user = userService.save(UserEntity.builder()
                .email(request.getEmail())
                .enabled(true)
                .role(role.orElse(null))
                .password(passwordEncoder.encode(request.getPassword()))
                .build());

        return "Usuario con email:".concat(user.getEmail()).concat(" registrado correctamente.");
    }
}
