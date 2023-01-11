package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberSerivceTest {
    MemberSerivce memberService;
    MemoryMemberRepository memberRepository;
    @BeforeEach

    public void beforeEach() //테스트 메소드가 실행되기전에 진행한다
    {
        memberRepository= new MemoryMemberRepository();
        memberService= new MemberSerivce(memberRepository);
    }

    @AfterEach                     //테스트 메소드가 끝날때마다 이게 동작한다.
    public void afterEach(){       //테스트가 진행하면서 매소드마나 객체를 비우기때문에 테스트를 문제없이 진행시킬수 있다.
        memberRepository.clearStore();
    }

    @Test  //테스트 메소드 이름은 한글로 적어도 괜찮다
    void 회원가입() {

        //Given
        Member member = new Member();
        member.setName("hello");

        //When
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertEquals(findMember.getName(),member.getName());
    }
    @Test
    public void 중복_회원_예외(){
        //Given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //When
        memberService.join(member1);
//        try{
//            memberService.join(member2);
//        }catch (IllegalStateException e)
//        {
//            Assertions.assertEquals(e.getMessage(),"이1미 존재하는 회원입니다.");
//        }


        IllegalStateException e = assertThrows(IllegalStateException.class, //예외 메세지를 받는다
                () -> memberService.join(member2));//예외가 발생해야 한다.

        Assertions.assertEquals(e.getMessage(),"이미 존재하는 회원입니다.");

    }

    @Test
    void findMember() {
    }

    @Test
    void findOne() {
    }
}