package apis.Manga.API.repository;

import apis.Manga.API.entity.Stadt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StadtRepository extends JpaRepository<Stadt, Long> {
}