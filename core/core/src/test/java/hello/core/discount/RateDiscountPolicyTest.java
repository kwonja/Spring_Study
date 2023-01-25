package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다")
    void vip_o(){
        //given
        Member member = new Member(1L,"A", Grade.VIP);

        //when
        int discount = discountPolicy.discount(member,10000);
        //then
        Assertions.assertEquals(discount,1000);
    }
    @Test
    @DisplayName("VIP가 아니면 할인이 적용되면 안된다") //테스트 이름을 이렇게 설정할수 있다.
    void vip_x(){
        //given
        Member member = new Member(2L,"A", Grade.BASIC);

        //when
        int discount = discountPolicy.discount(member,10000);
        //then
        Assertions.assertEquals(discount,10000);
    }
}