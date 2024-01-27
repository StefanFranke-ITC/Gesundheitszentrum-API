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

    //todo lob in texten

    @Lob
    private String bild;
    private String datum;
    private String autor;
    private String ueberschrift;
    @Lob
    private String text;

}
