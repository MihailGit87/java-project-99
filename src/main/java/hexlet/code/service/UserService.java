package hexlet.code.service;

import hexlet.code.dto.userDto.UserCreateDto;
import hexlet.code.dto.userDto.UserDto;
import hexlet.code.dto.userDto.UserUpdateDto;
import hexlet.code.exception.ResourceNotFoundException;
import hexlet.code.mapper.UserMapper;
import hexlet.code.repository.UserRepository;
import hexlet.code.util.UserUtils;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final UserUtils userUtils;

    private final PasswordEncoder passwordEncoder;

    public List<UserDto> getAll() {
        var users = userRepository.findAll();
        return users.stream()
                .map(userMapper::map)
                .toList();
    }

    public UserDto findById(Long id) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found by id: " + id));
        return userMapper.map(user);
    }

    public UserDto create(UserCreateDto dto) {
        var user = userMapper.map(dto);

        var hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        userRepository.save(user);
        return userMapper.map(user);
    }

    public UserDto update(UserUpdateDto dto, Long id) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found by id: " + id));

        userMapper.update(dto, user);

        var hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        userRepository.save(user);
        return userMapper.map(user);

    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
