package com.basics.ReviseSpringBasics.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@JsonPropertyOrder({ "status", "success", "message", "data", "error" })
public class ResponseUtil {
    private int status;
    private boolean success;
    private String message;
    private Object data;
    private String error;
}