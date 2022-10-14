package apis.Manga.API.Entety;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long nutzerId;
    @JsonIgnore
    private String password;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String email;
    private String valorant;
    private String strike;
    private String rocket;
    private String league;
    private String fortnite;
    private String pubg;
    private String cod;
    private String overwatch;
    private boolean status;
    private boolean admin;
    private boolean coAdmin;
    private String instagram;
    private String twitch;
    private String facebook;
    private int coin;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Clip> clips = new HashSet<>();


    public boolean isStatus() {
        return status;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public boolean isAdmin() {
        return admin;
    }

    public boolean isCoAdmin() {
        return coAdmin;
    }

    public void setCoAdmin(boolean coAdmin) {
        this.coAdmin = coAdmin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getTwitch() {
        return twitch;
    }

    public void setTwitch(String twitch) {
        this.twitch = twitch;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public long getNutzerId() {
        return nutzerId;
    }

    public void setNutzerId(long nutzerId) {
        this.nutzerId = nutzerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getValorant() {
        return valorant;
    }

    public void setValorant(String valorant) {
        this.valorant = valorant;
    }

    public String getStrike() {
        return strike;
    }

    public void setStrike(String strike) {
        this.strike = strike;
    }

    public String getRocket() {
        return rocket;
    }

    public void setRocket(String rocket) {
        this.rocket = rocket;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getFortnite() {
        return fortnite;
    }

    public void setFortnite(String fortnite) {
        this.fortnite = fortnite;
    }

    public String getPubg() {
        return pubg;
    }

    public void setPubg(String pubg) {
        this.pubg = pubg;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getOverwatch() {
        return overwatch;
    }

    public void setOverwatch(String overwatch) {
        this.overwatch = overwatch;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void add(User user) {
    }



}
