package com.food.service.errorhandler;

import lombok.Getter;

@Getter
public class ResourceNotFoundException extends Exception {
    private String code;
    private String feature;
    private String reason;

    public ResourceNotFoundException(String feature, String code, String reason) {
        super(reason);
        this.reason=reason;
        this.feature = feature;
        this.code = code;
    }
}
