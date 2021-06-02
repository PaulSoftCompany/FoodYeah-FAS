package com.paulsoft.user.dtos.customerDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCustomerDto {
    private String firstName;
    private String lastName;
    private String code;
    private String password;
}
