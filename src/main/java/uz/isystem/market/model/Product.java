package uz.isystem.market.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = ("product"))
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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

    // |- TODO connect productType -|

//    @ManyToOne
//    @JoinColumn(name = "product_type_id")


    @Column(name = ("product_type_id"))
    private String productTypeId;
}
