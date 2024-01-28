package apis.Manga.API.Controller;

import apis.Manga.API.Entety.Produkt;
import apis.Manga.API.Repository.ProduktRepository;
import apis.Manga.API.Service.ProduktService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/auth/produkt")
public class ProduktController {

    @Autowired
    private ProduktService produkteService;

    @Autowired
    private ProduktRepository produktRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Produkt> getProduktById(@PathVariable Long id) {
        Produkt produkt = produkteService.getProduktById(id);
        return ResponseEntity.ok(produkt);
    }

    @GetMapping()
    public List<Produkt> getAllProdukte() {
        return produktRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Produkt> createProdukt(@RequestBody Produkt produkt) {
        Produkt createdProdukt = produkteService.createProdukt(produkt);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProdukt);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProdukt(@PathVariable Long id) {
        produkteService.deleteProdukt(id);
        return ResponseEntity.noContent().build();
    }

    // Weitere Methoden hier hinzufügen, wenn benötigt.
}
