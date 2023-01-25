package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceimpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //구성정보를 담당한다 //beanfactory를 사용해서 등록하는 방법
public class AppConfig {

    @Bean
    public MemberService memberService() //생성자 주업이라고 한다. //이렇게 했을때 Memberservice는 레포지토리를 인터페이스만 가지게 된다,
                                                               //추상화 클래스만 가지게되어 독립적으로 진행할 수 있다.
    {
        return new MemberServiceimpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() //역활을 분리함
    {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl( memberRepository(),discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
    return  new RateDiscountPolicy();
    }

}
