package aivp.backend_volunteers.models.signup;

import lombok.Data;

@Data
public class SignUpRequestDto {
    private String fullName;
    private String email;
    private String password;
    private Boolean enabled;
    private Long roleId;
}
