package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberSerivce {

    private final MemberRepository memberRepository;

    MemberSerivce(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

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





