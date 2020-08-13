package com.app.api.enums;

import lombok.Getter;

public enum States {

    W("WAIT") ,
    F("FAIL"),
    M("MOVE"),
    S("SUCCESS");

    @Getter
    private String value;

    States(String value ) {
       this.value = value;
    }


}
