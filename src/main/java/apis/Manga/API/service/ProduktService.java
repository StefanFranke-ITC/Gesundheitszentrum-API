package apis.Manga.API.service;

import apis.Manga.API.Entety.Produkt;
import apis.Manga.API.Repository.ProduktRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;

@Service
public class ProduktService {

    @Autowired
    private ProduktRepository produkteRepository;

    public Produkt getProduktById(Long id) {
        return produkteRepository.findById(id).orElse(null);
    }

    public Produkt createProdukt(MultipartFile[] image, String text, String ueberschift, String link) {
        try {
            String base64Bild = Base64.getEncoder().encodeToString(image[0].getBytes());
            Produkt produkt = new Produkt(base64Bild, text, ueberschift, link);
            return produkteRepository.save(produkt);
        } catch (Exception e) {
            return null;
        }
    }

    public void deleteProdukt(Long id) {
        produkteRepository.deleteById(id);
    }

    // Weitere Methoden hier hinzufügen, wenn benötigt.
}
