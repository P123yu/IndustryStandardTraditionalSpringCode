package com.basics.ReviseSpringBasics.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatusCode;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class ResponseUtil {
    private int status;
    private boolean success;
    private String message;
    private Object data;
    private String error;
}
