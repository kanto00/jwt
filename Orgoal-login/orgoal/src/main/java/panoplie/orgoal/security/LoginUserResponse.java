package panoplie.orgoal.security;

public class LoginUserResponse {
    private final String accessToken;

    public LoginUserResponse(String accessToken){
        this.accessToken = accessToken;
    }
}
