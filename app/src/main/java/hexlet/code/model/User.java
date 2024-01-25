package hexlet.code.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.IDENTITY;

@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

//    расставить аннотации валидации
    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String email;

    @NotBlank
    private String password;

    @CreatedDate
    LocalDate createdAt;

    @LastModifiedDate
    LocalDate updateAt;
}
