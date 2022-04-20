package uz.isystem.market.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import uz.isystem.market.model.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDto {
    private Integer id;
    private UserDto userDto;
    @NotNull(message = "User id cannot be null")
    private Integer userId;
    private LocalDateTime deliveryDate;
    private String requirement;
    @NotBlank(message = "You have to write your contact")
    private String contact;
    @NotBlank(message = "You have to write your address")
    private String address;
    private LocalDateTime deliveredDate;
    private String status;
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;
    private LocalDateTime deletedDate;
}
