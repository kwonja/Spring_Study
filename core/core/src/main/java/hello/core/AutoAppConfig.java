package hello.core; //컴포넌트스캔의 default는 여기부터 시작

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan //@Component라는 어노테이션을 가지는 클래스를 전부 스프링빈에 자동 등록한다
        (
                basePackages = "hello.core", //core패키지부터 스캔이 들어간다.
                basePackageClasses = AutoAppConfig.class, //core 패키지내 autoappconfig부터 스캔을 시작한다.
                excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
//exclude로 제외해준 이유는 기존의 configuartion으로 등록한 빈들도 넣으면 중복이 되기때문 -> 예제로 사용하기위해서 이렇게 사용한것일뿐
//보통은 이렇게 제외해주지 않는다.
public class AutoAppConfig {
    @Bean(name = "memoryMemberRepository")
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
