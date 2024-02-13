package apis.Manga.API.service;

import apis.Manga.API.Repository.SeminarRepository;
import apis.Manga.API.entity.Seminar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeminarService {

    @Autowired
    private SeminarRepository seminarRepository;
    @Autowired
    private AuthService authService;

    public Seminar getSeminarById(Long id) {
        if (!authService.isAdmin()) return null;
        return seminarRepository.findById(id).orElse(null);
    }

    public Seminar createSeminar(Seminar seminar) {
        if (!authService.isAdmin()) return null;
        return seminarRepository.save(seminar);
    }

    public void deleteSeminar(Long id) {
        if (authService.isAdmin()) {
            seminarRepository.deleteById(id);
        }
    }

}
