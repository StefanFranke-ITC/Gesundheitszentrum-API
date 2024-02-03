package apis.Manga.API.service;

import apis.Manga.API.Entety.Bericht;
import apis.Manga.API.Repository.BerichtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;

@Service
public class BerichtService {

    @Autowired
    private BerichtRepository berichtRepository;

    public Bericht getBerichtById(Long id) {
        return berichtRepository.findById(id).orElse(null);
    }

    public Bericht createBericht(MultipartFile[] image, String text, String datum, String autor, String ueberschift) {
        try {
            String base64Bild = Base64.getEncoder().encodeToString(image[0].getBytes());
            Bericht bericht = new Bericht(base64Bild, text, datum, autor, ueberschift);
            return berichtRepository.save(bericht);
        } catch (Exception e) {
            return null;
        }
    }

    public void deleteBericht(Long id) {
        berichtRepository.deleteById(id);
    }

    // Weitere Methoden hier hinzufügen, wenn benötigt.
}
