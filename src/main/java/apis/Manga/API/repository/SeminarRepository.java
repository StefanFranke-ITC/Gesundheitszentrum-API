package apis.Manga.API.repository;

import apis.Manga.API.entity.Seminar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeminarRepository extends JpaRepository<Seminar, Long> {
    // Weitere benutzerdefinierte Abfragen können hier hinzugefügt werden, wenn benötigt.
}
