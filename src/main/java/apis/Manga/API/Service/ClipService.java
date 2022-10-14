package apis.Manga.API.Service;

import apis.Manga.API.Entety.Clip;
import apis.Manga.API.Entety.User;
import apis.Manga.API.Repository.ClipRepository;
import apis.Manga.API.Repository.UserRepository;
import apis.Manga.API.request.ClipRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ClipService {
    private  ClipRepository clipRepository;
    private  UserRepository userRepository;



    public ClipService(ClipRepository clipRepository, UserRepository userRepository){
        this.clipRepository = clipRepository;
        this.userRepository = userRepository;
    }

    public String erzeugeClip(ClipRequest clipRequest, long nutzerId) {
        User user = userRepository.findById(nutzerId);
        Clip clip = new Clip(clipRequest.getClipGame(), clipRequest.getClipName(),clipRequest.getClipUrl());
        clip.erzeuger(user);
        clipRepository.save(clip);
        return "Clip wurde erfolgreich erstellt";
    }

    public Clip ladeClip( long nutzerId){
        User user = userRepository.findById(nutzerId);
        Optional<Clip> clip = clipRepository.findById(user.getNutzerId());
        if(clip.isPresent()){
            return clip.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }
    }

