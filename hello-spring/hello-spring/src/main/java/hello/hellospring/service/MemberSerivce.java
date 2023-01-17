package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@Service //서비스라고 해줘야 스프링에서 가져올수 있음
@Transactional //서비스가 데이터에 잘 들어갔는지를 확인해주는 방법인듯? 테스트가 아닌 스프링부트에서의 transactional 일때
public class MemberSerivce {

    private final MemberRepository memberRepository;

    public MemberSerivce(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    long start = System.currentTimeMillis();
    public Long join (Member member)
    {
            validateDuplicateMember(member); //중복회원검사
            memberRepository.save(member);
            return member.getId(); //몇번째 회원인지
    }
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다."); //optional이 ifpresent같은 메소드를 제공해줌
                });
    }
    //전체회원 조회
    public List<Member> findMember()
    {
        return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long memberId) {

        return memberRepository.findById(memberId);
    }
    //래퍼지토리에서 가져와 기능을 실행함

}





