package com.saas.tenantservice.dto;

public class ApiResponse<T> {

    public String status;
    public T data;
    public String message;

    public ApiResponse(String status, T data, String message){
        this.status = status;
        this.data = data;
        this.message = message;
    }

}
