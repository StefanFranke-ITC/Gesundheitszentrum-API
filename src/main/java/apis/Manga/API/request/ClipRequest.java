package apis.Manga.API.request;

public class ClipRequest {
    private String clipGame;
    private String clipName;
    private String clipUrl;

    public ClipRequest(String clipGame, String clipName, String clipUrl){
        this.clipGame = clipGame;
        this.clipName = clipName;
        this.clipUrl = clipUrl;
    }

    public String getClipGame() {
        return clipGame;
    }

    public String getClipName() {
        return clipName;
    }

    public String getClipUrl() {
        return clipUrl;
    }
}
