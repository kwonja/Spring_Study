package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private  static Map<Long, Member> store = new HashMap<>(); //저장소가 없기때문에 따로 저장하기위해서 사용 //동시성 문제가 발생할수도
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return  member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // Nullable을 통해 Null이어도 반환을 해준다. hashmap에서 get은 key에 해당하는 value를 반환해준다.
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream().filter(member -> member.getName().equals(name)).findAny(); //findAny는 어떤거라도 찾는것 없다는 Null을 리턴
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear(); //hashmap 명령어중 객체를 초기화 하는것
    }
}
