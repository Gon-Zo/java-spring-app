package com.app.api.statics.group;

import lombok.*;

public class GroupDto {


    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Param {
        private long seq;
        private String title;
        private String info;
    }

}
