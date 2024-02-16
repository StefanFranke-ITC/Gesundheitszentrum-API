package apis.Manga.API.request;

import apis.Manga.API.entity.Leistung;
import apis.Manga.API.entity.Rechnung;

import java.util.List;

public class RechnungRequest {
    private Rechnung rechnung;
    private List<Leistung> leistungen;

    public Rechnung getRechnung() {
        return rechnung;
    }

    public List<Leistung> getLeistungen() {
        return leistungen;
    }

    public void setLeistungen(List<Leistung> leistungen) {
        this.leistungen = leistungen;
    }
}
