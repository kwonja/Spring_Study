package jpabook.jpashop.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Delivery {
    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;
    @OneToOne(mappedBy = "delivery") //일대일은 양쪽에
    //mappedBy 되는것은 해당 컬럼의 이름인듯
    private Order order;
    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING) //오리지날 타입은 숫자로 들어가게되는데, 순서가 바뀌면 큰일나기때문에 String으로 진행하는것이 좋다.
    private DeliveryStatus status; //READY,COMP

}
