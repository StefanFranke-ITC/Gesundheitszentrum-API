package apis.Manga.API.service;

import apis.Manga.API.repository.PreisRepository;
import apis.Manga.API.entity.Preis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;

@Service
public class PreisService {

    @Autowired
    private PreisRepository preisRepository;
    @Autowired
    private AuthService authService;

    public Preis getPreisById(Long id) {
        if (!authService.isAdmin()) return null;
        return preisRepository.findById(id).orElse(null);
    }

    public Preis createPreis(MultipartFile[] image, String text, String dauer, String ueberschift, String preis) {
        if (!authService.isAdmin()) return null;
        try {
            String base64Bild = Base64.getEncoder().encodeToString(image[0].getBytes());
            Preis preis1 = new Preis(ueberschift, base64Bild, preis, text, dauer);
            return preisRepository.save(preis1);
        } catch (Exception e) {
            return null;
        }
    }

    public void deletePreis(Long id) {
        if (authService.isAdmin()) {
            preisRepository.deleteById(id);
        }
    }
}
