package panoplie.orgoal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import panoplie.orgoal.domain.LoginForm;
import panoplie.orgoal.domain.Member;
import panoplie.orgoal.security.JwtTokenProvider;
import panoplie.orgoal.security.LoginUserResponse;
import panoplie.orgoal.service.MemberService;

@RestController
@RequestMapping("/signin")
public class SignInController {

    private final MemberService memberService;

    @Autowired
    public SignInController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity<LoginUserResponse>login(
            @RequestBody LoginForm loginForm) {

        LoginUserResponse loginUserResponse = memberService.signIn(loginForm);
        if (loginUserResponse == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok()
                    .body(loginUserResponse);
        }


    }
}
