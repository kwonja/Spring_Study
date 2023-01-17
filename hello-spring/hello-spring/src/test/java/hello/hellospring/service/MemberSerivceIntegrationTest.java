package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest //테스트인데도 스프링이 뜨도록 만들어준다 -> Springconfig 파일도 올라온다 그래서 선언만 해주면 되는듯?
@Transactional //테스트를 진행하는동안 들어간 데이터를 삭제하기때문에  테스트를 반복적으로 진행할수 있다.(중복에 걸리지않을수 있다)
               //테스트이전 데이터는 그냥 그대로 남아있음

class MemberSerivceIntegrationTest {

    //테스트를 진행할때는 DI를 신경쓸필요가 없기때문에 필드형태로 진행해도 나쁘지않다.
    @Autowired MemberSerivce memberService; //구현체는 @Configuration에 정의한곳에서 자동으로 올라온다.
    @Autowired MemberRepository memberRepository;



    @Test  //테스트 메소드 이름은 한글로 적어도 괜찮다
//    @Commit
    // 이렇게쓰면 그냥 커밋해버림->데이터베이스에 들어간다
    void 회원가입() {

        //Given
        Member member = new Member();
        member.setName("spring111");

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
//            Assertions.assertEquals(e.getMessage(),"이미 존재하는 회원입니다.");
//        }


        IllegalStateException e = assertThrows(IllegalStateException.class, //예외 메세지를 받는다
                () -> memberService.join(member2));//예외가 발생해야 한다.

        Assertions.assertEquals(e.getMessage(),"이미 존재하는 회원입니다.");

    }

    //서비스를 사용하기위해 회원가입한 모든 멤버 찾기 테스트
//    @Test
//    void findMember() {
//        Member member1 = new Member();
//        member1.setName("spring");
//
//        Member member2 = new Member();
//        member2.setName("hello");
//
//        memberService.join(member1);
//        memberService.join(member2);
//
//        List<Member> result = memberService.findMember();
//        for(Member member : result)
//        {
//            System.out.println(member.getName());
//        }
//        System.out.println(result.toString());
//
//    }
//
//    //서비스를 이용하는 회원중에서
//    @Test
//    void findOne() {
//        Member member1 = new Member();
//        member1.setName("spring");
//
//        Member member2 = new Member();
//        member1.setName("hello");
//
//        memberService.join(member1);
//        Member result = memberService.findOne(member1.getId()).get();
//
////        Assertions.assertEquals(result,member2);
//    }
}