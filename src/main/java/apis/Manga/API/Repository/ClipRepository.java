package apis.Manga.API.Repository;

import apis.Manga.API.Entety.Clip;
import apis.Manga.API.Entety.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClipRepository extends JpaRepository<Clip, Long> {


}
