package panoplie.orgoal.security;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;
import panoplie.orgoal.domain.Member;


import java.util.Date;

@Service
public class JwtTokenProvider  {
    private final String secretKey = "orgoalsecretkey";

    public JwtTokenProvider() {
    }

    public String createToken(Member member) {
        return Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .signWith(SignatureAlgorithm.HS256,secretKey)
                .setIssuedAt(new Date()).claim("id", member.getId())
                .compact();
    }

    private Claims parsingToken(String token) {
        return  Jwts.parser()
                .setSigningKey("orgoalsecretkey")
                .parseClaimsJws(token)
                .getBody();
    }

    public UserClaim getUserClaim(String authorizationHeader) {

        String token = extractToken(authorizationHeader);
        Claims claims = parsingToken(token);

        return new UserClaim(claims);
    }

    private String extractToken(String authorizationHeader) {
        return authorizationHeader.substring(secretKey.length());
    }
}
