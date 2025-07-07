package apis.Manga.API.service;

import apis.Manga.API.repository.UserRepository;
import apis.Manga.API.security.JwtAuthentificationFilter;
import apis.Manga.API.security.JwtTokenProvider;
import apis.Manga.API.entity.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public AuthService(UserRepository userRepository, JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public boolean isAdmin() {
        Optional<User> user = Optional.of(userRepository.findByEmail(jwtTokenProvider.getUserMailFromToken(JwtAuthentificationFilter.x)).get());
        return user.isPresent();
        /*return true;*/
    }
}
