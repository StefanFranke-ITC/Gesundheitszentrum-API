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

    @OneToMany(mappedBy = "rechnung", cascade = CascadeType.ALL)
    private List<Leistung> leistungen;

    public Rechnung(List<Leistung> leistungen, String straße, String plz, String ort, String hausnummer, String name, String vorname, String preis) {
        this.leistungen = leistungen;
        this.straße = straße;
        this.plz = plz;
        this.ort = ort;
        this.hausnummer = hausnummer;
        this.name = name;
        this.vorname = vorname;
        this.preis = preis;
    }
}
