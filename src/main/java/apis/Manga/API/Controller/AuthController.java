package apis.Manga.API.Controller;
import apis.Manga.API.Entety.Clip;
import apis.Manga.API.Repository.ClipRepository;
import apis.Manga.API.Service.ClipService;
import apis.Manga.API.Entety.User;
import apis.Manga.API.Repository.UserRepository;
import apis.Manga.API.Security.JwtAuthentificationFilter;
import apis.Manga.API.Security.JwtTokenProvider;
import apis.Manga.API.request.AuthRequest;
import apis.Manga.API.request.ClipRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/auth")
public class AuthController {

    private ClipService clipService;
   private UserRepository userRepository;
   private PasswordEncoder passwordEncoder;
   private AuthenticationManager authenticationManager;
   private JwtTokenProvider jwtTokenProvider;



    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, ClipService clipService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.clipService = clipService;

    }

    @CrossOrigin
    @PostMapping(value = "/Regist")
    public ResponseEntity<User> register(@RequestBody AuthRequest authRequest){
        Optional<User> userOptional = userRepository.findByEmail(authRequest.getEmail());
        if(userOptional.isPresent()) {
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
    @GetMapping("/user")
    public Optional<User> getUser(){
        return userRepository.findByEmail(jwtTokenProvider.getUserMailFromToken( JwtAuthentificationFilter.x) );
    }
    @CrossOrigin
    @GetMapping("/user/all/{nutzerId}")
    public User leseNutzerListe(@PathVariable long nutzerId){
        Optional<User> user = Optional.ofNullable(userRepository.findById(nutzerId));
        if(user.isPresent()){
            return user.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    @CrossOrigin
    @GetMapping("/user/all")
    public List<User> getUserAll(){
        return userRepository.findAll();
    }


    @CrossOrigin
    @PostMapping(value = "/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getEmail() ,
                        authRequest.getPassword()
                )
        );
        return ResponseEntity.ok(jwtTokenProvider.generateToken(authentication));
    }

    @CrossOrigin
    @PutMapping("user/{nutzerId}")
    public void  patchUser(@RequestBody User userUpdate, @PathVariable Long nutzerId){
        Optional<User> user = userRepository.findById(nutzerId);
        if(!user.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        User userInstance = user.get();
        userInstance.setValorant(userUpdate.getValorant());
        userInstance.setLeague(userUpdate.getLeague());
        userInstance.setStrike(userUpdate.getStrike());
        userInstance.setRocket(userUpdate.getRocket());
        userInstance.setFortnite(userUpdate.getFortnite());
        userInstance.setCod(userUpdate.getCod());
        userInstance.setOverwatch(userUpdate.getOverwatch());
        userInstance.setPubg(userUpdate.getPubg());
        userInstance.setInstagram(userUpdate.getInstagram());
        userInstance.setFacebook(userUpdate.getFacebook());
        userInstance.setTwitch(userUpdate.getTwitch());
        userRepository.save(userInstance);
    }
    @CrossOrigin
    @DeleteMapping("/user/all/{nutzerId}")
    public Boolean deleteOrder1( @PathVariable (value = "nutzerId") Long Id) {
        userRepository.deleteById(Id);
        return true;
    }
    @CrossOrigin
    @PutMapping("user/all/{nutzerId}")
    public void  patchUser1(@RequestBody User userUpdate, @PathVariable Long nutzerId){
        Optional<User> user = userRepository.findById(nutzerId);
        if(!user.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        User userInstance = user.get();
        userInstance.setUsername(userUpdate.getUsername());
        userInstance.setEmail(userUpdate.getEmail());
        userInstance.setAdmin(userUpdate.isAdmin());
        userInstance.setCoin(userUpdate.getCoin());
        userInstance.setCoAdmin(userUpdate.isCoAdmin());

        userRepository.save(userInstance);
    }
    @CrossOrigin
    @PostMapping(path="/clip/{nutzerId}")
    public String erzeugeClip(@RequestBody ClipRequest clipRequest, @PathVariable long nutzerId){
        return clipService.erzeugeClip(clipRequest,nutzerId);
    }


  /*  @CrossOrigin
    @GetMapping("/clip/{nutzerId}")
    public Clip ladeClip(@PathVariable Long nutzerId){
        return clipService.ladeClip(nutzerId);
    }*/


}
 /*  @GetMapping("/clip/{Id}")
    public Clip leseNutzerListe(@PathVariable Long Id){
        Optional<Clip> clip = clipRepository.findById(Id);
        if(clip.isPresent()){
            return clip.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    }*/

