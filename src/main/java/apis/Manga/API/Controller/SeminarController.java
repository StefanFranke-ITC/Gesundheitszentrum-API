package apis.Manga.API.Controller;

import apis.Manga.API.Repository.SeminarRepository;
import apis.Manga.API.entity.Seminar;
import apis.Manga.API.service.SeminarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/auth/seminar")
public class SeminarController {

    @Autowired
    private SeminarService seminarService;

    @Autowired
    private SeminarRepository seminarRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Seminar> getSeminarById(@PathVariable Long id) {
        Seminar seminar = seminarService.getSeminarById(id);
        return ResponseEntity.ok(seminar);
    }

    @GetMapping()
    public List<Seminar> getAllSeminare() {
        return seminarRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Seminar> createSeminar(@RequestBody Seminar seminar) {
        Seminar createdSeminar = seminarService.createSeminar(seminar);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSeminar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeminar(@PathVariable Long id) {
        seminarService.deleteSeminar(id);
        return ResponseEntity.noContent().build();
    }

    // Weitere Methoden hier hinzufügen, wenn benötigt.
}
