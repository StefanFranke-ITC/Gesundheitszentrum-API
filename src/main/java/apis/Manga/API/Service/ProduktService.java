package apis.Manga.API.Service;

import apis.Manga.API.Entety.Produkt;
import apis.Manga.API.Repository.ProduktRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProduktService {

    @Autowired
    private ProduktRepository produkteRepository;

    public Produkt getProduktById(Long id) {
        return produkteRepository.findById(id).orElse(null);
    }

    public Produkt createProdukt(Produkt produkt) {
        return produkteRepository.save(produkt);
    }

    public void deleteProdukt(Long id) {
        produkteRepository.deleteById(id);
    }

    // Weitere Methoden hier hinzufügen, wenn benötigt.
}
