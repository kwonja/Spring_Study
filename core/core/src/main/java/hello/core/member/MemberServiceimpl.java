package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Component
public class MemberServiceimpl implements MemberService{

    private final MemberRepository memberRepository;
    //순수한 자바코드로 진행하면서 Memory라는 구현체 에 의존하기때문에 DIP를 위반하기에 않좋은 코딩 방식이다.

    @Autowired //ac.getbean(MemberRepository.class)
    public MemberServiceimpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
