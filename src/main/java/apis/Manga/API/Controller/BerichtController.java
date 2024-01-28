package apis.Manga.API.Controller;

import apis.Manga.API.Entety.Bericht;
import apis.Manga.API.Repository.BerichtRepository;
import apis.Manga.API.Service.BerichtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Bericht> createBericht(@RequestBody Bericht bericht) {
        Bericht createdBericht = berichtService.createBericht(bericht);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBericht);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBericht(@PathVariable Long id) {
        berichtService.deleteBericht(id);
        return ResponseEntity.noContent().build();
    }

    // Weitere Methoden hier hinzufügen, wenn benötigt.
}
