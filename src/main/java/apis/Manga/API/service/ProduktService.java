package apis.Manga.API.service;

import apis.Manga.API.Repository.ProduktRepository;
import apis.Manga.API.entity.Produkt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;

@Service
public class ProduktService {

    @Autowired
    private ProduktRepository produkteRepository;
    @Autowired
    private AuthService authService;

    public Produkt getProduktById(Long id) {
        if (!authService.isAdmin()) return null;
        return produkteRepository.findById(id).orElse(null);
    }

    public Produkt createProdukt(MultipartFile[] image, String text, String ueberschift, String link) {
        if (!authService.isAdmin()) return null;
        try {
            String base64Bild = Base64.getEncoder().encodeToString(image[0].getBytes());
            Produkt produkt = new Produkt(base64Bild, text, ueberschift, link);
            return produkteRepository.save(produkt);
        } catch (Exception e) {
            return null;
        }
    }

    public void deleteProdukt(Long id) {
        if (authService.isAdmin()) {
            produkteRepository.deleteById(id);
        }
    }

    // Weitere Methoden hier hinzufügen, wenn benötigt.
}
