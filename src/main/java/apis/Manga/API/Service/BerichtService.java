package apis.Manga.API.Service;

import apis.Manga.API.Entety.Bericht;
import apis.Manga.API.Repository.BerichtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BerichtService {

    @Autowired
    private BerichtRepository berichtRepository;

    public Bericht getBerichtById(Long id) {
        return berichtRepository.findById(id).orElse(null);
    }

    public Bericht createBericht(Bericht bericht) {
        return berichtRepository.save(bericht);
    }

    public void deleteBericht(Long id) {
        berichtRepository.deleteById(id);
    }

    // Weitere Methoden hier hinzufügen, wenn benötigt.
}
