package apis.Manga.API.request;

import apis.Manga.API.entity.Leistung;
import apis.Manga.API.entity.Rechnung;
import lombok.Getter;

import java.util.List;

@Getter
public class RechnungRequest {
    private Rechnung rechnung;
    private List<Leistung> leistungen;

    public void setLeistungen(List<Leistung> leistungen) {
        this.leistungen = leistungen;
    }
}
