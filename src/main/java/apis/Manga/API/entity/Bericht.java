package apis.Manga.API.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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

    private String backlinkUrl;
    private String backlinkName;

    @Lob
    private String bild;
    @Lob
    private String datum;
    private String autor;
    private String ueberschrift;
    @Lob
    private String text;

    public Bericht(String bild, String text, String datum, String autor, String ueberschrift, String backlinkUrl, String backlinkName) {
        this.bild = bild;
        this.backlinkName = backlinkName;
        this.backlinkUrl = backlinkUrl;
        this.datum = datum;
        this.autor = autor;
        this.ueberschrift = ueberschrift;
        this.text = text;
    }
}
