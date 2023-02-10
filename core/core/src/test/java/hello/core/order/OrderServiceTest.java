package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceimpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderServiceTest {


    MemberService memberService;
    OrderService orderService;

    @BeforeEach

//    void BeforeEach(){
//        AppConfig appConfig = new AppConfig();
//        memberService = appConfig.memberService();
//        orderService = appConfig.orderService();
//    }

    @Test //순수한 자바코드 테스트
    public void OrderApp(){
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); //스프링컨테이너를 실행시켜준다고 하네요
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService",OrderService.class);
        //OrderService , OrderServiceimpi 객체를 둘다 불러도 orderService의 빈 이름은 OrderServiceimpi 객체랑 연결되어있어서
        //똑같이 나온다.
        System.out.println(orderService.getClass());
        //스프링에 등록된 빈의 이름과 빈의 타입을 작성하면 자동으로 클래스를 생성해준다.
        Member member = new Member(0L,"권성민", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(member.getId(), "홍가라비",15000);
        System.out.println(order.toString());


    }
}
