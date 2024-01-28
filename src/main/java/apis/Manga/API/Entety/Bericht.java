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
    @Lob
    private String datum;
    private String autor;
    private String ueberschrift;
    @Lob
    private String text;

    public Bericht(String bild, String text, String datum, String autor, String ueberschrift) {
        this.bild = bild;
        this.datum = datum;
        this.autor = autor;
        this.ueberschrift = ueberschrift;
        this.text = text;
    }
}
