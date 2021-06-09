package com.paulsoft.user.dtos.customerDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.paulsoft.user.dtos.orderDto.OrderDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class CustomerDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String code;
    private Boolean state;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    List<OrderDto> orders;
}
