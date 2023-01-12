package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberSerivce;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//직접 스프링 빈을 등록하는 방식
@Configuration
public class SpringConfig {
    @Bean
    public MemberSerivce memberSerivce(){
        return new MemberSerivce(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

}
