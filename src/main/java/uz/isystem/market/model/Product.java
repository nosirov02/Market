package uz.isystem.market.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = ("products"))
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = ("product_type_id"), insertable = false, updatable = false)
    private ProductType productType;

    @Column(name = ("product_type_id"))
    private Integer productTypeId;

    @Column(name = ("name"))
    private String name;

    @Column(name = ("description"))
    private String description;

    @Column(name = ("price"))
    private Double price;

    @Column(name = ("rate"))
    private Integer rate;

    @Column(name = ("visible"))
    private Boolean visible;

    @Column(name = ("status"))
    private String status;

    @Column(name = ("created_at"))
    private LocalDateTime createdAt;

    @Column(name = ("update_at"))
    private LocalDateTime updateAt;

    @Column(name = ("deleted_at"))
    private LocalDateTime deletedAt;
}
