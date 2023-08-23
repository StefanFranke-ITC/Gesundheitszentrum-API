package apis.Manga.API.Entety;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long nutzerId;
    private String status;
    @JsonIgnore
    private String password;
    @Column(unique = true)
    private String username;
    private String email;

    public String getStatus() {
        return status;
    }

    public String getUsername() {
        return username;
    }
}
