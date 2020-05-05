package com.app.api.enums;

public enum ImageType {

    R("review"),
    Q("question");

    private String value ;

    ImageType(String value ){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

}
