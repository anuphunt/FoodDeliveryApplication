package com.food.service.errorhandler;

import lombok.Getter;

@Getter
public class RemoteApiException extends Exception{
    private String code;
    private String feature;
    private String reason;

    public RemoteApiException(String feature, String code, String reason) {
        super(reason);
        this.reason=reason;
        this.feature = feature;
        this.code = code;
    }
}
