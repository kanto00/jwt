package panoplie.orgoal.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import panoplie.orgoal.domain.Member;

import java.util.List;

@Repository
public interface MemberRepository {

    @Select("Select * from member")
    List<Member> getMembers();

    @Insert("Insert into member values(#{member.id},#{member.nickname},#{member.password},#{member.question},#{member.answer})")
    void save(@Param("member") Member member);

    @Select("Select * from member " +
            "where id = #{id}")
    Member findById(String id);
}
