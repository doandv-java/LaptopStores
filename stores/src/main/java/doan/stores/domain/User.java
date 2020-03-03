package doan.stores.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "users")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "name")
    private String name;

    @Column(name = "birth_day")
    private Date birthDay;

    @Column(name = "gender")
    private int gender;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "image_link")
    private String imageLink;

    @Column(name = "state")
    private int state;

    @Column(name = "deleted")
    private int deleted;

}
