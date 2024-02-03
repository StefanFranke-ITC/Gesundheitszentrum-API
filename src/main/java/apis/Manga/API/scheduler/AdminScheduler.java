package apis.Manga.API.scheduler;

import apis.Manga.API.Entety.User;
import apis.Manga.API.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AdminScheduler {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public AdminScheduler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Scheduled(initialDelay = 0, fixedDelay = Long.MAX_VALUE)
    public void createUserOnStartup() {
        Optional<User> existingUser = userRepository.findByEmail("admin");
        if (existingUser.isEmpty()) {
            User user = new User();
            user.setEmail("admin");
            user.setPassword(passwordEncoder.encode("admin"));
            userRepository.save(user);
        }
    }
}

