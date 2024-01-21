package apis.Manga.API.Service;

import apis.Manga.API.Entety.Seminar;
import apis.Manga.API.Repository.SeminarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeminarService {

    @Autowired
    private SeminarRepository seminarRepository;

    public Seminar getSeminarById(Long id) {
        return seminarRepository.findById(id).orElse(null);
    }

    public Seminar createSeminar(Seminar seminar) {
        return seminarRepository.save(seminar);
    }

    public void deleteSeminar(Long id) {
        seminarRepository.deleteById(id);
    }

    // Weitere Methoden hier hinzufügen, wenn benötigt.
}
