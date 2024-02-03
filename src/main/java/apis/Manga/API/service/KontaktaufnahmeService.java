package apis.Manga.API.service;

import apis.Manga.API.Entety.Kontaktaufnahme;
import apis.Manga.API.Repository.KontaktaufnahmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KontaktaufnahmeService {

    @Autowired
    private KontaktaufnahmeRepository kontaktaufnahmeRepository;

    public Kontaktaufnahme getKontaktaufnahmeById(Long id) {
        return kontaktaufnahmeRepository.findById(id).orElse(null);
    }

    public Kontaktaufnahme createKontaktaufnahme(Kontaktaufnahme kontakt) {
        return kontaktaufnahmeRepository.save(kontakt);
    }

    public void deleteKontaktaufnahme(Long id) {
        kontaktaufnahmeRepository.deleteById(id);
    }

    // Weitere Methoden hier hinzufügen, wenn benötigt.
}
