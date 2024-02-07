package hexlet.code.controller.api;

//import hexlet.code.dto.UserDTO.UserCreateDto;
import hexlet.code.dto.userDto.UserDto;
//import hexlet.code.dto.UserDTO.UserUpdateDto;
import hexlet.code.service.UserService;
//import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    private static final String ONLY_OWNER_BY_ID
            = "@userRepository.findById(#id).get().getEmail() == authentication.getName()";

    private UserService userService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<UserDto>> index() {
        var result = userService.getAll();
        return ResponseEntity.ok()
                .header("X-Total-Count", String.valueOf(result.size()))
                .body(result);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto show(@PathVariable long id) {
        return userService.findById(id);
    }

//    @PostMapping("")
//    @ResponseStatus(HttpStatus.CREATED)
//    public UserDto create(@Valid @RequestBody UserCreateDto userData) {
//        return userService.create(userData);
//    }

//    @PutMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    @PreAuthorize(ONLY_OWNER_BY_ID)
//    UserDto update(@RequestBody UserUpdateDto userData, @PathVariable Long id) {
//        return userService.update(userData, id);
//    }

//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @PreAuthorize(ONLY_OWNER_BY_ID)
//    public void delete(@PathVariable Long id) {
//        userService.delete(id);
//    }
}
