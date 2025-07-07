// apis/Manga/API/controller/SeminareNeuController.java
package apis.Manga.API.Controller;

import apis.Manga.API.entity.SeminareNeu;
import apis.Manga.API.entity.Stadt;
import apis.Manga.API.repository.SeminareNeuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/auth/seminare")
public class SeminareNeuController {

    private final SeminareNeuService service;
    private final SeminareNeuService seminareNeuService;

    public SeminareNeuController(SeminareNeuService service, SeminareNeuService seminareNeuService) {
        this.service = service;
        this.seminareNeuService = seminareNeuService;
    }

    /** Alle Seminare holen **/
    @GetMapping
    public ResponseEntity<List<SeminareNeu>> getAll() {
        List<SeminareNeu> list = service.getAllSeminare();
        return ResponseEntity.ok(list);
    }

    /** Seminar nach ID holen **/
    @GetMapping("/{id}")
    public ResponseEntity<SeminareNeu> getById(@PathVariable Long id) {
        try {
            SeminareNeu sem = service.getSeminar(id);
            return ResponseEntity.ok(sem);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /** Neues Seminar anlegen **/
    @PostMapping
    public ResponseEntity<SeminareNeu> create(@RequestBody SeminareNeu seminar) {
        SeminareNeu saved = service.createSeminar(seminar);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }


    /**
     * Seminar nach URL holen
     */
    @GetMapping("/url/{url}")
    public ResponseEntity<SeminareNeu> getSeminarByUrl(@PathVariable String url) {
        return service.getAllSeminare().stream()
                .filter(s -> s.getUrl().equalsIgnoreCase(url))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    /** Seminar updaten **/
    @PutMapping("/{id}")
    public ResponseEntity<SeminareNeu> update(
            @PathVariable Long id,
            @RequestBody SeminareNeu seminar) {
        try {
            SeminareNeu updated = service.updateSeminar(id, seminar);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /** Seminar löschen **/
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            service.deleteSeminar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
