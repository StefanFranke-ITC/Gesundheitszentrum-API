package apis.Manga.API.Controller;
import java.util.List;

import apis.Manga.API.Entety.Clip;
import apis.Manga.API.Repository.ClipRepository;
import apis.Manga.API.Repository.UserRepository;
import org.springframework.web.bind.annotation.*;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@CrossOrigin
@RestController
@RequestMapping("/auth")
public class ClipController {

    private ClipRepository clipRepository;
    private UserRepository userRepository;


    public ClipController(ClipRepository clipRepository) {
        this.clipRepository = clipRepository;

    }

   @CrossOrigin
   @GetMapping("/clip")
    public List<Clip> getClip(){
        return clipRepository.findAll();
    }

    @CrossOrigin
   @GetMapping("/clip/sortiert/{nutzerId}")
    public List<Clip> leseNutzerListe(@PathVariable Long nutzerId){
        List<Clip> clips = clipRepository.findAll();
        return  clips.stream().filter(c->c.getUser().getNutzerId() == nutzerId).collect(Collectors.toList());
    }

    @CrossOrigin
    @GetMapping("/clip/{nutzerId}")
    public Clip leseNutzerListe(@PathVariable long nutzerId){
        Optional<Clip> clip = clipRepository.findById(nutzerId);
        if(clip.isPresent()){
            return clip.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @DeleteMapping("/{clipId}")
    public Boolean deleteOrder( @PathVariable (value = "clipId") Long Id) {
        clipRepository.deleteById(Id);
        return true;
    }

    @CrossOrigin
    @PutMapping("/clip/{clipId}")
    public void  patchClip(@RequestBody Clip clipUpdate, @PathVariable Long clipId) {
        Optional<Clip> clip = clipRepository.findById(clipId);
        if (!clip.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Clip clipInstance = clip.get();
        clipInstance.setReport(clipUpdate.getReport());
        clipInstance.setClipScore(clipUpdate.getClipScore());
        clipInstance.setClicks(clipUpdate.getClicks());
        clipInstance.setClipStatus(clipUpdate.isClipStatus());
        clipInstance.setAvrScore(clipUpdate.getAvrScore());
        clipInstance.setClipGame(clipUpdate.getClipGame());
        clipInstance.setClipUrl(clipUpdate.getClipUrl());
        clipInstance.setClipName(clipUpdate.getClipName());
        clipRepository.save(clipInstance);
    }
}
