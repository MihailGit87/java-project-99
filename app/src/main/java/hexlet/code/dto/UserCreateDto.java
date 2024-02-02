package hexlet.code.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateDto {
    private String firstName;

    private String lastName;

    @Email
    private String email;

    @NotBlank
    private String password;
}