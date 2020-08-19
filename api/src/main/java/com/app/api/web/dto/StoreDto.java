package com.app.api.web.dto;

import com.app.api.domain.store.Store;
import com.app.api.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class StoreDto {

    private String title;

    private String phone;

    private String address;

    private String img;

    private long userSeq;

    @Setter
    private User user;

    public Store toEntity(){

        return Store.builder()
                .title(title)
                .phone(phone)
                .address(address)
                .img(img)
                .user(user)
                .build();

    }

}
