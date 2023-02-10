package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class MemoryMemberRepository implements MemberRepository{
    private  Long sequence=0L;
    private static Map<Long,Member> store= new HashMap<>(); //동시성 이슈가 있을수 있지만 테스트용이라서 괜찮다.

    @Override
    public void save(Member member) {
        member.setId(sequence++);
        store.put(member.getId(), member);

    }
    @Override
    public Member findById(Long memberId) {
        return store.get(memberId); //long에 대한 member를 반환해주는듯
    }
}