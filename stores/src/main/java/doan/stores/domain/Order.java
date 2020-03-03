package doan.stores.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "orders")
@Entity
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "status")
    private int status;

    @Column(name = "total_money")
    private double totalMoney;
}
