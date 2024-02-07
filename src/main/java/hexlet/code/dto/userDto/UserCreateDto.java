package hexlet.code.dto.userDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateDto {
    private String firstName;
    private String lastName;

    @NotBlank
    @Size(min = 3)
    private String passwordDigest;

    @Email
    private String email;
}
