package apis.Manga.API.Controller;

import apis.Manga.API.Repository.PreisRepository;
import apis.Manga.API.entity.Preis;
import apis.Manga.API.service.PreisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
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
    public ResponseEntity<Preis> createPreis(@RequestParam("files") MultipartFile[] image, @RequestParam("text") String text, @RequestParam("dauer") String dauer, @RequestParam("ueberschrift") String ueberschift, @RequestParam("preis") String preis) {
        Preis createdPreis = preisService.createPreis(image, text, dauer, ueberschift, preis);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPreis);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePreis(@PathVariable String id) {
        preisService.deletePreis(Long.parseLong(id));
        return ResponseEntity.noContent().build();
    }
}
