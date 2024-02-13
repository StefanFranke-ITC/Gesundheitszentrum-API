package apis.Manga.API.service;

import apis.Manga.API.Repository.LeistungRepository;
import apis.Manga.API.entity.Leistung;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeistungService {

    @Autowired
    private LeistungRepository leistungRepository;
    @Autowired
    private AuthService authService;

    public Leistung getLeistungById(Long id) {
        if (!authService.isAdmin()) return null;
        Optional<Leistung> leistungOptional = leistungRepository.findById(id);
        return leistungOptional.orElse(null);
    }

    public List<Leistung> getAllLeistungen() {
        if (!authService.isAdmin()) return null;
        return leistungRepository.findAll();
    }

    public Leistung createLeistung(Leistung leistung) {
        if (!authService.isAdmin()) return null;
        return leistungRepository.save(leistung);
    }

    public void deleteLeistung(Long id) {
        if (authService.isAdmin()) {
            leistungRepository.deleteById(id);
        }
    }

}
