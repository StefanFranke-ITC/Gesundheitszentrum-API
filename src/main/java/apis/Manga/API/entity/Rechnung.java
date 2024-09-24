package apis.Manga.API.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Rechnung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String vorname;
    private String straße;
    private String hausnummer;
    private String plz;
    private String ort;
    private String preis;
    private String datum;
    private String firma;

    @OneToMany(mappedBy = "rechnung", cascade = CascadeType.ALL)
    private List<Leistung> leistungen;

}
