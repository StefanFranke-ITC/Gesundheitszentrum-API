package apis.Manga.API.Controller;

import apis.Manga.API.entity.Leistung;
import apis.Manga.API.entity.Rechnung;
import apis.Manga.API.request.RechnungRequest;
import apis.Manga.API.service.RechnungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/auth/rechnung")
public class RechnungController {

    @Autowired
    private RechnungService rechnungService;

    @GetMapping("/{id}")
    public ResponseEntity<Rechnung> getRechnungById(@PathVariable Long id) {
        Rechnung rechnung = rechnungService.getRechnungById(id);
        return ResponseEntity.ok(rechnung);
    }

    @GetMapping()
    public List<Rechnung> getAllRechnungen() {
        return rechnungService.getAllRechnungen();
    }

    @PostMapping
    public ResponseEntity<Rechnung> createRechnung(@RequestBody RechnungRequest rechnung) {
        Rechnung createdRechnung = rechnungService.createRechnung(rechnung);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRechnung);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRechnung(@PathVariable Long id) {
        rechnungService.deleteRechnung(id);
        return ResponseEntity.noContent().build();
    }
}
