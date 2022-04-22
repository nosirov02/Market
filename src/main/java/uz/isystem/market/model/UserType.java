package uz.isystem.market.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = ("user_type"))
public class UserType {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name =("name"))
    private  String name;

    @Column(name =("status"))
    private  String status;

    @Column(name =("created_at"))
    private LocalDateTime createdAt;

    @Column(name =("updated_at"))
    private LocalDateTime updatedAt;

    @Column(name =("deleted_at"))
    private LocalDateTime deletedAt;


}
