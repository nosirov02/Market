package uz.isystem.market.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = ("user_type"))
public class UserType {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;


}
