package hello.hellospring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // jpa에서 해당 객체를 엔티티로 사용한다는 의미이다.
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //pk설정과 generate? 하나씩 자동으로 늘려주는걸 선언 increment와 다른거일까?
    private Long id;
    //
    // @Column(name = "username") //DB에 있는 username와 매핑이 된다.
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
