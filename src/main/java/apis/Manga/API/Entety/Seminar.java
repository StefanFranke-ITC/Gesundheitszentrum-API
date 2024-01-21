package apis.Manga.API.Entety;
import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Seminar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String ueberschrift;
    private String vonDatum;
    private String bisDatum;
    private String vonUhrzeit;
    private String bisUhrzeit;
    private String text;
    private String preis;
    private String ort;
    private String straße;
    private String plz;

}
