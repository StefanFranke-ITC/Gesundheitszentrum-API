package apis.Manga.API.Service;

import apis.Manga.API.Entety.Preis;
import apis.Manga.API.Repository.PreisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreisService {

    @Autowired
    private PreisRepository preisRepository;

    public Preis getPreisById(Long id) {
        return preisRepository.findById(id).orElse(null);
    }

    public Preis createPreis(Preis preis) {
        return preisRepository.save(preis);
    }

    public void deletePreis(Long id) {
        preisRepository.deleteById(id);
    }

    // Weitere Methoden hier hinzufügen, wenn benötigt.
}
