package uz.isystem.market.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = ("orders"))
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = ("user_id"), insertable = false, updatable = false)
    private User user;

    @Column(name = ("user_id"))
    private Integer userId;

    @Column(name = ("deliveryDate"))
    private LocalDateTime deliveryDate;

    @Column(name = ("requirement"))
    private String requirement;

    @Column(name = ("contact"))
    private String contact;

    @Column(name = ("address"))
    private String address;

    @Column(name = ("deliveredDate"))
    private LocalDateTime deliveredDate;

    @Column(name = ("status"))
    private String status;

    @Column(name = ("created_date"))
    private LocalDateTime createdDate;

    @Column(name = ("update_date"))
    private LocalDateTime updateDate;

    @Column(name = ("deleted_date"))
    private LocalDateTime deletedDate;
}
