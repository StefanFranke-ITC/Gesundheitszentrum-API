package apis.Manga.API.Entety;
import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Bericht {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String bild;
    private String datum;
    private String autor;
    private String ueberschrift;
    private String text;

}
