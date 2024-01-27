package apis.Manga.API.Entety;
import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Data
@Entity
public class Preis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String ueberschrift;
    @Lob
    private String bild;
    private String preis;
    @Lob
    private String text;
    private String dauer;

    public Preis(String ueberschrift, String bild, String preis, String text, String dauer) {
        this.ueberschrift = ueberschrift;
        this.bild = bild;
        this.preis = preis;
        this.text = text;
        this.dauer = dauer;
    }
}
