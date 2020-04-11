package com.food.service.errorhandler;

import lombok.Data;

@Data
public class ErrorResponse {
    String feature;
    String code;
    String message;
}
