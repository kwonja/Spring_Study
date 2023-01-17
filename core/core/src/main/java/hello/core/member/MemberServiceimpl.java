package hello.core.member;

public class MemberServiceimpl implements MemberService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //순수한 자바코드로 진행하면서 Memory라는 구현체 에 의존하기때문에 DIP를 위반하기에 않좋은 코딩 방식이다.

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
