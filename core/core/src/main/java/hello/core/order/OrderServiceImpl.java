package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{ //인터페이스에만 의존하고 구현체자체에는 의존하고 있지않기때문에 DI를 지키고 있다
    private final MemberRepository memberRepository;
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy; //구현체가 존재해서 구현체 의존관계를 지웠지만 ,인터페이스는 추상화라서 인스턴스로 사용이 불가능하다

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice); //할인정책이 수정되더라도, 오더서비스를 수정할필요가 없다

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
