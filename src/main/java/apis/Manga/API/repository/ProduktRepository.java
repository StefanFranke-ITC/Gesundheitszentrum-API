package apis.Manga.API.repository;

import apis.Manga.API.entity.Produkt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduktRepository extends JpaRepository<Produkt, Long> {
    // Weitere benutzerdefinierte Abfragen können hier hinzugefügt werden, wenn benötigt.
}
