package uz.isystem.market.dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {

    private Integer id;
    @NotBlank(message = "Product name is mandatory")
    private String name;
    private String description;
    @NotNull(message = "Product name is mandatory")
    private Double price;
    private Integer rate;
    private Boolean visible;
    private String status;
    private Integer productTypeId;
    private ProductTypeDto productTypeDto;
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;
    private LocalDateTime deletedDate;
}
