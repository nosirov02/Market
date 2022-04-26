package uz.isystem.market.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrderFilterDto extends FilterDto{
    private UserDto userDto;
    private Integer userId;
    private String address;
    private String contact;
    private LocalDateTime createdDate;
    private LocalDateTime deliveredDate;
    private LocalDateTime deliveryDate;
}
