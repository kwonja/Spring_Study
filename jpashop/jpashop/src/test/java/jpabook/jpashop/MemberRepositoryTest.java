package jpabook.jpashop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class) //junit에게 스프링부트 관련하여 테스트를 진행할거라는걸 알려줌
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;
    @Test
    @Transactional //테스트에 있으면 db를 롤백해버린다.
    @Rollback(false)
    public void testMember() throws Exception
    {
        Member member = new Member();
        member.setUsername("memberA");
        Member member2 = new Member();
        member.setUsername("memberB");

        //when
        Long saveId = memberRepository.save(member);
        Long saveId2 = memberRepository.save(member2);
        Member member1 = memberRepository.find(saveId);

        //then
        Assertions.assertThat(member1.getId()).isEqualTo(member.getId());
        Assertions.assertThat(member1.getUsername()).isEqualTo(member.getUsername());
        //id가 같고 캐쉬에 존재하기때문에 select문을 날리지 않고 바로 가져온다.-> find함수
    }
}