package uz.isystem.market.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import uz.isystem.market.model.User;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderItemDto {
    private Integer id;
    private User user;
}
