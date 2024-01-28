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

    public Produkt(String bild, String text, String ueberschrift, String link) {
        this.bild = bild;
        this.text = text;
        this.ueberschrift = ueberschrift;
        this.link = link;
    }
}
