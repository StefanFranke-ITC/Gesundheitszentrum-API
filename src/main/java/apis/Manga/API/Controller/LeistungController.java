package apis.Manga.API.Controller;

import apis.Manga.API.entity.Leistung;
import apis.Manga.API.service.LeistungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/auth/leistung")
public class LeistungController {

    @Autowired
    private LeistungService leistungService;

    @GetMapping("/{id}")
    public ResponseEntity<Leistung> getLeistungById(@PathVariable Long id) {
        Leistung leistung = leistungService.getLeistungById(id);
        return ResponseEntity.ok(leistung);
    }

    @GetMapping()
    public List<Leistung> getAllLeistungen() {
        return leistungService.getAllLeistungen();
    }

    @PostMapping
    public ResponseEntity<Leistung> createLeistung(@RequestBody Leistung leistung) {
        Leistung createdLeistung = leistungService.createLeistung(leistung);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLeistung);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLeistung(@PathVariable Long id) {
        leistungService.deleteLeistung(id);
        return ResponseEntity.noContent().build();
    }

    // Weitere Methoden hier hinzufügen, wenn benötigt.
}
