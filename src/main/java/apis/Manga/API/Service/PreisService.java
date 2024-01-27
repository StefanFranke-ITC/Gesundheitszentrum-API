package apis.Manga.API.Service;

import apis.Manga.API.Entety.Preis;
import apis.Manga.API.Repository.PreisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;

@Service
public class PreisService {

    @Autowired
    private PreisRepository preisRepository;

    public Preis getPreisById(Long id) {
        return preisRepository.findById(id).orElse(null);
    }

    public Preis createPreis(MultipartFile[] image, String text, String dauer, String ueberschift, String preis) {
        try {
            String base64Bild = Base64.getEncoder().encodeToString(image[0].getBytes());
            Preis preis1 = new Preis(ueberschift, base64Bild, preis, text, dauer);
            return preisRepository.save(preis1);
        } catch (Exception e) {
            return null;
        }
    }

    public void deletePreis(Long id) {
        preisRepository.deleteById(id);
    }

    // Weitere Methoden hier hinzufügen, wenn benötigt.
}
