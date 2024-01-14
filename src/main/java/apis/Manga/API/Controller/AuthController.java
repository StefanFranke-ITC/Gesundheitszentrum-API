package apis.Manga.API.Controller;
import apis.Manga.API.Entety.*;

import apis.Manga.API.Repository.UserRepository;
import apis.Manga.API.Security.JwtTokenProvider;
import apis.Manga.API.request.AuthRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthController {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    private AuthenticationManager authenticationManager;
    private JwtTokenProvider jwtTokenProvider;


    public AuthController(  UserRepository userRepository, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @GetMapping("/user")
    public List<User> getUser() {
        return userRepository.findAll();
    }
    @CrossOrigin
    @PostMapping(value = "/regist")
    public ResponseEntity<User> register(@RequestBody AuthRequest authRequest) {
        Optional<User> userOptional = userRepository.findByEmail(authRequest.getEmail());
        if (userOptional.isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        User user = new User();
        user.setEmail(authRequest.getEmail());
        user.setUsername(authRequest.getUsername());

        user.setPassword(passwordEncoder.encode(authRequest.getPassword()));
        User created = userRepository.save(user);
        return ResponseEntity.ok(created);

    }

    @CrossOrigin
    @PostMapping(value = "/login")
    public ResponseEntity<Map<String, Object>>  login(@RequestBody AuthRequest authRequest) {
        try{
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getEmail(),
                        authRequest.getPassword()
                )
        );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwtToken = jwtTokenProvider.generateToken(authentication);

            Optional<User> userDetails = userRepository.findByEmail(authRequest.getEmail());;

            Map<String, Object> response = new HashMap<>();
            response.put("token", jwtToken);
            response.put("user", userDetails);

            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            // Handle authentication failure
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }



    }



}




