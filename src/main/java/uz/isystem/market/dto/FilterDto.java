package uz.isystem.market.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;

@Getter
@Setter
public class FilterDto {
    private String sortBy;
    private Integer page;
    private Integer size;
    private Sort.Direction direction;
}
