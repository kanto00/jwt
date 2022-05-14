package panoplie.orgoal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import panoplie.orgoal.domain.LoginForm;
import panoplie.orgoal.domain.Member;
import panoplie.orgoal.repository.MemberRepository;
import panoplie.orgoal.security.JwtTokenProvider;
import panoplie.orgoal.security.LoginUserResponse;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void signUp(Member member) {

        memberRepository.save(member);
    }

    public LoginUserResponse signIn(LoginForm loginForm) {
        Member member = memberRepository.findById(loginForm.getId());
        if (member == null) {
            return null;
        }
        member.setPassword(member.getPassword().trim());
        String token = jwtTokenProvider.createToken(member);
        if (member.getPassword().equals(loginForm.getPassword())) {
            return new LoginUserResponse(token);
        } else {
            return null;
        }
    }


}
