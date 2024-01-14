package apis.Manga.API.Repository;


import apis.Manga.API.Entety.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String Email);
    User findById(long nutzerId);
}
