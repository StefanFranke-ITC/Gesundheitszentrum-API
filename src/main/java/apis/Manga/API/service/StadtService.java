package apis.Manga.API.service;

import apis.Manga.API.entity.Stadt;
import apis.Manga.API.repository.StadtRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StadtService {

    private final StadtRepository stadtRepository;

    public StadtService(StadtRepository stadtRepository) {
        this.stadtRepository = stadtRepository;
    }

    /**
     * Legt eine neue Stadt an (inkl. aller neuen Felder).
     */
    public Stadt createStadt(Stadt stadt) {
        // Optional: Validierungen für Pflichtfelder einbauen
        return stadtRepository.save(stadt);
    }

    /**
     * Aktualisiert eine bestehende Stadt.
     */
    public Stadt updateStadt(Long id, Stadt stadtData) {
        Stadt existing = stadtRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stadt nicht gefunden mit ID " + id));

        existing.setName(stadtData.getName());
        existing.setText(stadtData.getText());
        existing.setÜberschrift(stadtData.getÜberschrift());
        existing.setImage(stadtData.getImage());
        existing.setAutor(stadtData.getAutor());
        existing.setUnterUeberschrift(stadtData.getUnterUeberschrift());
        existing.setMiniUnterUeberschrift(stadtData.getMiniUnterUeberschrift());

        return stadtRepository.save(existing);
    }

    /**
     * Liefert eine Stadt nach ihrer ID.
     */
    public Stadt getStadt(Long id) {
        return stadtRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stadt nicht gefunden mit ID " + id));
    }

    /**
     * Liefert alle Städte.
     */
    public List<Stadt> getAllStädte() {
        return stadtRepository.findAll();
    }

    /**
     * Löscht eine Stadt.
     */
    public void deleteStadt(Long id) {
        Stadt toDelete = stadtRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stadt nicht gefunden mit ID " + id));
        stadtRepository.delete(toDelete);
    }
}
