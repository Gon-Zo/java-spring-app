package com.app.api.statics.group;

import lombok.*;

public class GroupDto {


    @Setter
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Param{
        private long seq;
        private String title;
        private String info;
    }



}
