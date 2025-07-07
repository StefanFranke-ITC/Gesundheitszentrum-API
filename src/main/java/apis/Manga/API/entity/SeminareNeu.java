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
public class SeminareNeu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String ueberschrift;
    private String unterUeberschrift;
    private String miniUnterUeberschrift;
    @Lob
    private String text;

    private String url;
    @Lob
    private String image;
}
