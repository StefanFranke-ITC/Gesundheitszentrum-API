package apis.Manga.API.Repository;

import apis.Manga.API.entity.Leistung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeistungRepository extends JpaRepository<Leistung, Long> {
}
