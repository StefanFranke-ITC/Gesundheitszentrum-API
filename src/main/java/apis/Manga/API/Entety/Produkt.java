package apis.Manga.API.Entety;
import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Produkt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Lob
    private String bild;
    @Lob
    private String text;
    private String ueberschrift;
    private String link;
}
