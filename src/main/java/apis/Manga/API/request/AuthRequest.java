package apis.Manga.API.request;


import lombok.Getter;

@Getter
public class AuthRequest {
    private String email;
    private String password;


    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
