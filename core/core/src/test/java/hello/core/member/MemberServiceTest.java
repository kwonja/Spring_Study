package hello.core.member;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceimpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    private MemberService memberService;
    @BeforeEach
    public  void beforeEach()
    {
        memberService = new MemberServiceimpl();
    }
    @Test
    public void 회원가입()
    {
        //given-조건
        Member member = new Member(1L,"memberA", Grade.VIP);

        //when-테스트하고싶은 함수가 돌아갔을때
        memberService.join(member);

        //then 잘들어갓는지 확인
        Member result = memberService.findMember(member.getId());
        Assertions.assertEquals(result,member);

    }
}
