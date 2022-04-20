package uz.isystem.market.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProductDto {

    private Integer id;
    private String name;
    private String description;
    private Double price;
    private Integer rate;
    private Boolean visible;
    private String productTypeId;
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;
    private LocalDateTime deletedDate;
}
