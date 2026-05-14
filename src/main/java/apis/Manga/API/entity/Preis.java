package apis.Manga.API.entity;

import javax.persistence.*;

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

    public Preis() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUeberschrift() {
        return ueberschrift;
    }

    public void setUeberschrift(String ueberschrift) {
        this.ueberschrift = ueberschrift;
    }

    public String getBild() {
        return bild;
    }

    public void setBild(String bild) {
        this.bild = bild;
    }

    public String getPreis() {
        return preis;
    }

    public void setPreis(String preis) {
        this.preis = preis;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDauer() {
        return dauer;
    }

    public void setDauer(String dauer) {
        this.dauer = dauer;
    }
}
