package doan.stores.domain;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "advertises")
@Data
public class Advertise extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "content")
    private String content;

    @Column(name = "image_link")
    private String imageLink;

    @Column(name = "active")
    private int active;
}
