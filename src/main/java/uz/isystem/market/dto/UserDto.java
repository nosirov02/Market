package uz.isystem.market.dto;

import uz.isystem.market.model.UserType;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserDto {
    @NotNull
    private Integer id;

    private UserType userType;

    @NotNull
    private Integer userTypeId;

    @NotBlank
    private String name;

    private String surname;

    private String email;

    @NotBlank
    private String password;

    private Integer imageId;

    private String status;

    @NotBlank
    private String address;
}
