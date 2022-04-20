package uz.isystem.market.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import uz.isystem.market.model.Order;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderItemDto {
    private Integer id;
    private OrderDto orderDto;
    private Integer orderId;
    private ProductDto productDto;
    private Integer productId;
    private String status;
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;
    private LocalDateTime deletedDate;
}
