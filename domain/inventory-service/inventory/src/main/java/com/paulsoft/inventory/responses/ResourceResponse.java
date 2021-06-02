package com.paulsoft.inventory.responses;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceResponse<T> implements Serializable {
    private static final long serialVersionUID=1L;

    private String status;
    private String code;
    private String message;
    private T data;

    public ResourceResponse(String status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public ResourceResponse(String status, String code, String message, T data) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
