package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//스프링jpa가 자동으로 구현체를 만들어 스프링 bean에 자동 등록해서 사용한다.
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository{
    //JPQL 문법으로 select m from Member m where m.name=?
    //인터페이스 이름으로 개발을 할수 있다고 하네요
    @Override
    Optional<Member> findByName(String name);


}
