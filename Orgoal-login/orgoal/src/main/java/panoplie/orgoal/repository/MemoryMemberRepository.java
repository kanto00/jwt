package panoplie.orgoal.repository;

import panoplie.orgoal.domain.Member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository{

    private static final Map<String, Member> store = new HashMap<>();

    public Member save(Member member) {
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(String id) {

        for (String s : store.keySet()) {
            if (s.equals(id)) {
                return store.get(s);
            }
        }

        return null;
    }


}
