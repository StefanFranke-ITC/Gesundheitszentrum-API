package apis.Manga.API.Repository;

import apis.Manga.API.entity.Preis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreisRepository extends JpaRepository<Preis, Long> {
    // Weitere benutzerdefinierte Abfragen können hier hinzugefügt werden, wenn benötigt.
}
