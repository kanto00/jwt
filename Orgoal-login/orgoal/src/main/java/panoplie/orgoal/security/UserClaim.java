package panoplie.orgoal.security;

import io.jsonwebtoken.Claims;

public class UserClaim {

    private final Long id;
    private final String email;

    public UserClaim(Claims claims) {
        this.id = claims.get("id", Long.class);
        this.email = claims.get("email", String.class);
    }

}
