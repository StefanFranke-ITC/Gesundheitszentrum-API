package apis.Manga.API.scheduler;

import apis.Manga.API.repository.UserRepository;
import apis.Manga.API.entity.User;
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
        Optional<User> existingUser = userRepository.findByEmail("andreabachem83@gmail.com");
        if (existingUser.isEmpty()) {
            User user = new User();
            user.setEmail("andreabachem83@gmail.com");
            user.setPassword(passwordEncoder.encode("olli123katze"));
            userRepository.save(user);
        }
    }
}

