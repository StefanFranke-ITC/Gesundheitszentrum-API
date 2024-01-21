package apis.Manga.API.Repository;

import apis.Manga.API.Entety.Kontaktaufnahme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KontaktaufnahmeRepository extends JpaRepository<Kontaktaufnahme, Long> {
    // Weitere benutzerdefinierte Abfragen können hier hinzugefügt werden, wenn benötigt.
}
