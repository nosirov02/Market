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
@Entity(name = ("product"))
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // |- TODO connect productType -|

//    @ManyToOne
//    @JoinColumn(name = "product_type_id")

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

    @Column(name = "status")
    private String status;

    @Column(name = ("product_type_id"))
    private String productTypeId;

    @Column(name = ("created_date"))
    private LocalDateTime createdDate;

    @Column(name = ("update_date"))
    private LocalDateTime updateDate;

    @Column(name = ("deleted_date"))
    private LocalDateTime deletedDate;
}
