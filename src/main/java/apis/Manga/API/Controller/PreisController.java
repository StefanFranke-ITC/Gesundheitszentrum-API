package apis.Manga.API.Controller;

import apis.Manga.API.Entety.Preis;
import apis.Manga.API.Repository.PreisRepository;
import apis.Manga.API.Service.PreisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth/preis")
public class PreisController {

    @Autowired
    private PreisService preisService;

    @Autowired
    private PreisRepository preisRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Preis> getPreisById(@PathVariable Long id) {
        Preis preis = preisService.getPreisById(id);
        return ResponseEntity.ok(preis);
    }

    @GetMapping
    public List<Preis> getAllPreise() {
        return preisRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Preis> createPreis(@RequestBody Preis preis) {
        Preis createdPreis = preisService.createPreis(preis);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPreis);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePreis(@PathVariable Long id) {
        preisService.deletePreis(id);
        return ResponseEntity.noContent().build();
    }

    // Weitere Methoden hier hinzufügen, wenn benötigt.
}
