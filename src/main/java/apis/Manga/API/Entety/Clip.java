package apis.Manga.API.Entety;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Clip {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long clipId;
    private String clipGame;
    private int clipScore;
    private String clipName;
    private String clipUrl;
    private int report;
    private boolean clipStatus;
    private long clicks;
    private double avrScore;



    @ManyToOne
    @JoinColumn(name = "nutzerId", referencedColumnName = "nutzerId")
    private User user;

    public Clip(String clipGame, String clipName, String clipUrl) {
        this.clipGame=clipGame;
        this.clipName=clipName;
        this.clipUrl=clipUrl;
    }

    public Clip() {

    }

    public double getAvrScore() {
        return avrScore;
    }

    public void setAvrScore(double avrScore) {
        this.avrScore = avrScore;
    }

    public long getNutzerId(){

        return user.getNutzerId();
    }

    public User getUser() {
        return user;
    }

    public long getClipId() {
        return clipId;
    }

    public void setClipId(long clipId) {
        this.clipId = clipId;
    }

    public String getClipGame() {
        return clipGame;
    }

    public void setClipGame(String clipGame) {
        this.clipGame = clipGame;
    }

    public int getClipScore() {
        return clipScore;
    }

    public void setClipScore(int clipScore) {
        this.clipScore = clipScore;
    }

    public String getClipName() {
        return clipName;
    }

    public void setClipName(String clipName) {
        this.clipName = clipName;
    }

    public String getClipUrl() {
        return clipUrl;
    }

    public void setClipUrl(String clipUrl) {
        this.clipUrl = clipUrl;
    }

    public int getReport() {
        return report;
    }

    public void setReport(int report) {
        this.report = report;
    }

    public boolean isClipStatus() {
        return clipStatus;
    }

    public void setClipStatus(boolean clipStatus) {
        this.clipStatus = clipStatus;
    }

    public long getClicks() {
        return clicks;
    }

    public void setClicks(long clicks) {
        this.clicks = clicks;
    }

    public void add(Clip clip) {
    }
    public void erzeuger(User user){
        this.user=user;
    }
}
