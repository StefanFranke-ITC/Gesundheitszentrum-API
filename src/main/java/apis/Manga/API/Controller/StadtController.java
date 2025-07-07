package apis.Manga.API.Controller;

import apis.Manga.API.entity.Stadt;
import apis.Manga.API.service.StadtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/auth/stadt")
public class StadtController {

    private final StadtService stadtService;

    public StadtController(StadtService stadtService) {
        this.stadtService = stadtService;
    }

    /**
     * Alle Stadtnamen holen
     */
    @GetMapping("/namen")
    public ResponseEntity<List<String>> getAllStadtNamen() {
        List<String> namen = stadtService.getAllStädte().stream()
                .map(Stadt::getName)
                .collect(Collectors.toList());
        return ResponseEntity.ok(namen);
    }

    /**
     * Alle Städte holen
     **/
    @GetMapping
    public ResponseEntity<List<Stadt>> getAllStädte() {
        return ResponseEntity.ok(stadtService.getAllStädte());
    }

    /**
     * Stadt nach ID holen
     **/
    @GetMapping("/{id}")
    public ResponseEntity<Stadt> getStadtById(@PathVariable Long id) {
        try {
            Stadt stadt = stadtService.getStadt(id);
            return ResponseEntity.ok(stadt);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Stadt nach Namen holen
     **/
    @GetMapping("/name/{name}")
    public ResponseEntity<Stadt> getStadtByName(@PathVariable String name) {
        return stadtService.getAllStädte().stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Neue Stadt anlegen
     **/
    @PostMapping
    public ResponseEntity<Stadt> createStadt(@RequestBody Stadt stadt) {
        if (stadt.getName() == null || stadt.getName().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        Stadt saved = stadtService.createStadt(stadt);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    /**
     * Bestehende Stadt updaten
     **/
    @PutMapping("/{id}")
    public ResponseEntity<Stadt> updateStadt(
            @PathVariable Long id,
            @RequestBody Stadt stadt) {
        try {
            Stadt updated = stadtService.updateStadt(id, stadt);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Stadt löschen
     **/
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStadt(@PathVariable Long id) {
        try {
            stadtService.deleteStadt(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
