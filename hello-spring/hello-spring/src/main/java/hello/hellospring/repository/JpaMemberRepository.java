package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em; //Jpa를 사용할때 스프링부트에서 자동으로 만들어준다 Jpa를 사용하려면 필수!

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return  member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name").setParameter("name",name).getResultList();

        return result.stream().findAny(); //Optional형태로 반환
    }

    @Override
    public List<Member> findAll() {
        List<Member> result = em.createQuery("select m from Member as m ", Member.class).getResultList(); //jpq 같은 다른언어인듯?
        return result;
    }
}
