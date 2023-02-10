package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
//1. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();
//2. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();
//참조값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);
//memberService1 != memberService2
        Assertions.assertEquals(memberService1,memberService2);
    }
    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest()
    {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        Assertions.assertEquals(singletonService1,singletonService2);
        //smae은 주소값이 같으면 참
        //equals는 정말 같이 같으면 참
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer()
    {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
//
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);

        MemberService memberService2 = ac.getBean("memberService", MemberService.class);
//참조값이 같아진다-> 스프링이 싱글톤 컨테이너를 제공해준다.
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);
//memberService1 == memberService2
        Assertions.assertEquals(memberService1,memberService2); //같은 객체를 사용하는것을 알 수 있다.
    }
}
