package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach                     //메소드가 끝날때마다 이게 동작한다.
    public void afterEach(){       //테스트가 진행하면서 매소드마나 객체를 비우기때문에 테스트를 문제없이 진행시킬수 있다.
        repository.clearStore();
    }

    @Test
    public void save() {
//given
        Member member = new Member();
        member.setName("spring");
//when
        repository.save(member);
//then
        Member result = repository.findById(member.getId()).get(); //optonal에서 get()으로 값을 꺼낼수가 있는데 test는 그냥 꺼내도 갠춘
        Assertions.assertEquals(member,result);
    }
    @Test
    public void findByname(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get(); //get이 optional을 반환하는것
        Assertions.assertEquals(member1,result);
    }
    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result=repository.findAll();
        Assertions.assertEquals(result.size(),2);
    }

}
