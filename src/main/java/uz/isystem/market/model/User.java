package uz.isystem.market.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = ("user"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = ("name"))
    private String name;
    @Column(name = ("surname"))
    private String surname;
    @Column(name = ("email"))
    private String email;
    @Column(name = ("password"))
    private String password;
    @Column(name = ("image_id"))
    private Integer imageId;
    @Column(name = ("status"))
    private String status;

}
