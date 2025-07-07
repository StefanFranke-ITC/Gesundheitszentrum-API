package apis.Manga.API.repository;

import apis.Manga.API.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
    // Weitere benutzerdefinierte Abfragen können hier hinzugefügt werden, wenn benötigt.
}
