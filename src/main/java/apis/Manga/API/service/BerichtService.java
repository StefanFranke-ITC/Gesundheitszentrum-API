package apis.Manga.API.service;

import apis.Manga.API.Repository.BerichtRepository;
import apis.Manga.API.entity.Bericht;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;

@Service
public class BerichtService {

    @Autowired
    private final AuthService authService;
    @Autowired
    private BerichtRepository berichtRepository;

    public BerichtService(BerichtRepository berichtRepository, AuthService authService) {
        this.berichtRepository = berichtRepository;
        this.authService = authService;
    }

    public Bericht getBerichtById(Long id) {
        return berichtRepository.findById(id).orElse(null);
    }

    public Bericht createBericht(MultipartFile[] image, String text, String datum, String autor, String ueberschift) {
        if (!authService.isAdmin()) return null;
        System.out.println(authService.isAdmin());
        try {
            String base64Bild = Base64.getEncoder().encodeToString(image[0].getBytes());
            Bericht bericht = new Bericht(base64Bild, text, datum, autor, ueberschift);
            return berichtRepository.save(bericht);
        } catch (Exception e) {
            return null;
        }
    }

    public void deleteBericht(Long id) {
        if (authService.isAdmin()) {
            berichtRepository.deleteById(id);
        }
    }

    // Weitere Methoden hier hinzufügen, wenn benötigt.
}
