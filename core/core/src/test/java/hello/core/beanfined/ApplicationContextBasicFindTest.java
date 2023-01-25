package hello.core.beanfined;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceimpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    @Test
    @DisplayName("모든 빈 출력하기")
    void findBeanByName()
    {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        Assertions.assertInstanceOf(MemberServiceimpl.class,memberService);
    }
    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType()
    {
        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertInstanceOf(MemberServiceimpl.class,memberService);
    }
    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2()
    {
        MemberService memberService = ac.getBean("memberService", MemberServiceimpl.class); //실제 구체적인것으로 가능하지만 역활이 아닌 구현에 의존한 코드이기때문에 안좋다
        Assertions.assertInstanceOf(MemberServiceimpl.class,memberService);
    }
    @Test
    @DisplayName("빈 이름으로 조회X")
    void findBeanByNameX()
    {
        //ac.getBean("xxxx", MemberService.class);
        Assertions.assertThrows(NoSuchBeanDefinitionException.class,()-> ac.getBean("xxxx", MemberService.class));
        //오른쪽의 식이 실행하면 왼쪽의 예외가 터져야한다는 의미의 코드 -> 예외가 나온다는것
    }

}
