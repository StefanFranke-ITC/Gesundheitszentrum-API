// apis/Manga/API/service/SeminareNeuService.java
package apis.Manga.API.repository;

import apis.Manga.API.entity.SeminareNeu;
import apis.Manga.API.repository.SeminareNeuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeminareNeuService {

    private final SeminareNeuRepository repository;

    public SeminareNeuService(SeminareNeuRepository repository) {
        this.repository = repository;
    }

    /** Neues Seminar anlegen **/
    public SeminareNeu createSeminar(SeminareNeu seminar) {
        return repository.save(seminar);
    }

    /** Bestehendes Seminar aktualisieren **/
    public SeminareNeu updateSeminar(Long id, SeminareNeu data) {
        SeminareNeu existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Seminar nicht gefunden mit ID " + id));

        existing.setUeberschrift(data.getUeberschrift());
        existing.setUnterUeberschrift(data.getUnterUeberschrift());
        existing.setMiniUnterUeberschrift(data.getMiniUnterUeberschrift());
        existing.setText(data.getText());
        existing.setUrl(data.getUrl());
        existing.setImage(data.getImage());

        return repository.save(existing);
    }

    /** Seminar nach ID holen **/
    public SeminareNeu getSeminar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Seminar nicht gefunden mit ID " + id));
    }

    /** Alle Seminare holen **/
    public List<SeminareNeu> getAllSeminare() {
        return repository.findAll();
    }

    /** Seminar löschen **/
    public void deleteSeminar(Long id) {
        SeminareNeu existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Seminar nicht gefunden mit ID " + id));
        repository.delete(existing);
    }
}
