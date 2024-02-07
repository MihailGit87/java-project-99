package hexlet.code.dto.userDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDto {
    @Email
    private String email;

    private String firstName;

    private String lastName;

    @NotBlank
    private String password;
}
