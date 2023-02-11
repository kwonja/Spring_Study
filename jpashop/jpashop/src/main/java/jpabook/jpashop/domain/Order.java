package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name= "member_id") //왜래키 이름이 member_id라고 보면된다. //pk를 통해 조인하는방식이 맞는듯
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList();

    @OneToOne
    @JoinColumn(name="delivery_id")
    private Delivery delivery;
    private LocalDateTime orderDate; //java8부터 시간을 지원해줌 -> 주문 시간
    @Enumerated(EnumType.STRING) //DB에 저장되는 방식인듯
    private OrderStatus status; //주문,취소


}
