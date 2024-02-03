package apis.Manga.API.Controller;

import apis.Manga.API.Entety.Kontaktaufnahme;
import apis.Manga.API.Repository.KontaktaufnahmeRepository;
import apis.Manga.API.service.KontaktaufnahmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/auth/kontaktaufnahme")
public class KontaktaufnahmeController {

    @Autowired
    private KontaktaufnahmeService kontaktaufnahmeService;

    @Autowired
    private KontaktaufnahmeRepository kontaktaufnahmeRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Kontaktaufnahme> getKontaktaufnahmeById(@PathVariable Long id) {
        Kontaktaufnahme kontakt = kontaktaufnahmeService.getKontaktaufnahmeById(id);
        return ResponseEntity.ok(kontakt);
    }

    @GetMapping()
    public List<Kontaktaufnahme> getAllKontaktaufnahmen() {
        return kontaktaufnahmeRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Kontaktaufnahme> createKontaktaufnahme(@RequestBody Kontaktaufnahme kontakt) {
        Kontaktaufnahme createdKontakt = kontaktaufnahmeService.createKontaktaufnahme(kontakt);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdKontakt);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKontaktaufnahme(@PathVariable Long id) {
        kontaktaufnahmeService.deleteKontaktaufnahme(id);
        return ResponseEntity.noContent().build();
    }

    // Weitere Methoden hier hinzufügen, wenn benötigt.
}
