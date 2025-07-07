package apis.Manga.API.repository;

import apis.Manga.API.entity.Bericht;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BerichtRepository extends JpaRepository<Bericht, Long> {
    // Weitere benutzerdefinierte Abfragen können hier hinzugefügt werden, wenn benötigt.
}
