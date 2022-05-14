package panoplie.orgoal.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import panoplie.orgoal.domain.Member;
import panoplie.orgoal.repository.MemberRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("전제 회원 가져오기")
    void getMember() {
        System.out.println("테스트" + memberRepository.getMembers());
    }

    @Test
    @DisplayName("회원 저장")
    void saveMember() {
        Member member = new Member("가나다", "바보", "asdf1234", "PETNAME", "멍멍이");
        memberRepository.save(member);
        Member findbyId = memberRepository.findById(member.getId());
        assertEquals(member.getId(), findbyId.getId());
    }

    @Test
    @DisplayName("회원 찾기")
    void findByID() {
        String id = "hky0105@naver.com";
        Member member = memberRepository.findById(id);
        assertEquals(id, member.getId());
    }
}