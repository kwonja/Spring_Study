package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//직접 스프링 빈을 등록하는 방식
@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
//    private EntityManager em;
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }
////    private DataSource dataSource; //스프링이 applocation.properties에 있는걸 찾아서 자동으로 등록해줌
////    @Autowired
////    public SpringConfig(DataSource dataSource) {
////        this.dataSource = dataSource;
////    }

    @Bean
    public MemberSerivce memberSerivce(){
        return new MemberSerivce(memberRepository);
    }

    @Bean
    public TimeTraceAop timeTraceAop(){
        return  new TimeTraceAop();
    }

//    @Bean
//    public MemberRepository memberRepository(){
//        return  new JpaMemberRepository(em);
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcMemberRepository(dataSource); //Bean의 장점은 갈아끼울수 있다는 점! 대신 datasource를 생성자 매개변수로 받는다.
        //        return new MemoryMemberRepository();
//    }

}
