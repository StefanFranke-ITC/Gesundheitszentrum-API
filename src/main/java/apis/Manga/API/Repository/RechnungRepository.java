package apis.Manga.API.Repository;

import apis.Manga.API.entity.Rechnung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RechnungRepository extends JpaRepository<Rechnung, Long> {
}
