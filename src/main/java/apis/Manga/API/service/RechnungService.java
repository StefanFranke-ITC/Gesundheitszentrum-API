package apis.Manga.API.service;

import apis.Manga.API.Repository.RechnungRepository;
import apis.Manga.API.entity.Rechnung;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RechnungService {

    @Autowired
    private RechnungRepository rechnungRepository;
    @Autowired
    private AuthService authService;

    public Rechnung getRechnungById(Long id) {
        if (!authService.isAdmin()) return null;
        Optional<Rechnung> rechnungOptional = rechnungRepository.findById(id);
        return rechnungOptional.orElse(null);
    }

    public List<Rechnung> getAllRechnungen() {
        if (!authService.isAdmin()) return null;
        return rechnungRepository.findAll();
    }

    public Rechnung createRechnung(Rechnung rechnung) {
        if (!authService.isAdmin()) return null;
        return rechnungRepository.save(rechnung);
    }

    public void deleteRechnung(Long id) {
        if (authService.isAdmin()) {
            rechnungRepository.deleteById(id);

        }
    }

}
