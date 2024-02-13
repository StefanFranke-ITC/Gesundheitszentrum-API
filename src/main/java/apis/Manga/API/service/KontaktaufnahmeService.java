package apis.Manga.API.service;

import apis.Manga.API.Repository.KontaktaufnahmeRepository;
import apis.Manga.API.entity.Kontaktaufnahme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KontaktaufnahmeService {

    @Autowired
    private KontaktaufnahmeRepository kontaktaufnahmeRepository;
    @Autowired
    private AuthService authService;

    public Kontaktaufnahme getKontaktaufnahmeById(Long id) {
        if (!authService.isAdmin()) return null;
        return kontaktaufnahmeRepository.findById(id).orElse(null);
    }

    public Kontaktaufnahme createKontaktaufnahme(Kontaktaufnahme kontakt) {
        return kontaktaufnahmeRepository.save(kontakt);
    }

    public void deleteKontaktaufnahme(Long id) {
        if (authService.isAdmin()) {
            kontaktaufnahmeRepository.deleteById(id);
        }
    }

    // Weitere Methoden hier hinzufügen, wenn benötigt.
}
