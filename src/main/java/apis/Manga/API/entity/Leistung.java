package apis.Manga.API.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Leistung {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "rechnungs_id", referencedColumnName = "id")
    private Rechnung rechnung;
    private String preis;
    @Lob
    private String text;
    private String menge;
}
