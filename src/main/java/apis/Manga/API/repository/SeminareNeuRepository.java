// apis/Manga/API/repository/SeminareNeuRepository.java
package apis.Manga.API.repository;

import apis.Manga.API.entity.SeminareNeu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeminareNeuRepository extends JpaRepository<SeminareNeu, Long> {
}
