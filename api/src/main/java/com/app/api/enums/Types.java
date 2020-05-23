package com.app.api.enums;

public enum Types {

    review("R"),
    question("Q"),
    product("P");

    private String value ;

    Types(String value ){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

}
