package hexlet.code.util;

import hexlet.code.model.User;
import hexlet.code.repository.UserRepository;
import net.datafaker.Faker;
import org.instancio.Instancio;
import org.instancio.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class TestUtils {

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    @Autowired
    private Faker faker;

    @Autowired
    private UserUtils userUtils;

    @Autowired
    private UserRepository userRepository;

    @Bean
    public User generateUser() {
        return Instancio.of(User.class)
                .ignore(Select.field(User::getId))
                .ignore(Select.field(User::getCreatedAt))
                .ignore(Select.field(User::getUpdateAt))
                .supply(Select.field(User::getFirstName), () -> faker.name().firstName())
                .supply(Select.field(User::getLastName), () -> faker.name().lastName())
                .supply(Select.field(User::getEmail), () -> faker.internet().emailAddress())
                .supply(Select.field(User::getPassword), () -> faker.internet().password())
                .create();
    }

    @Bean
    public void clean() {
        userRepository.deleteAll();
    }
}
