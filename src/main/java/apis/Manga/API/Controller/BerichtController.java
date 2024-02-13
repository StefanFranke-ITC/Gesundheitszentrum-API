package apis.Manga.API.Controller;

import apis.Manga.API.Repository.BerichtRepository;
import apis.Manga.API.entity.Bericht;
import apis.Manga.API.service.BerichtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/auth/bericht")
public class BerichtController {

    @Autowired
    private BerichtService berichtService;

    @Autowired
    private BerichtRepository berichtRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Bericht> getBerichtById(@PathVariable Long id) {
        Bericht bericht = berichtService.getBerichtById(id);
        return ResponseEntity.ok(bericht);
    }

    @GetMapping()
    public List<Bericht> getAllBerichte() {
        return berichtRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Bericht> createBericht(@RequestParam("files") MultipartFile[] image, @RequestParam("text") String text, @RequestParam("autor") String autor, @RequestParam("ueberschrift") String ueberschift, @RequestParam("datum") String datum) {
        Bericht createdBericht = berichtService.createBericht(image, text, datum, autor, ueberschift);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBericht);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBericht(@PathVariable Long id) {
        berichtService.deleteBericht(id);
        return ResponseEntity.noContent().build();
    }

}
