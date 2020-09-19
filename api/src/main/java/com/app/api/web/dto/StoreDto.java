package com.app.api.web.dto;

import com.app.api.domain.store.Store;
import com.app.api.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Create by park031517@gmail.com on 2020-08-19, 수
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Getter
@ToString
@NoArgsConstructor
public class StoreDto {

    String name;

    String accountNumber;

    private long userSeq;

    @Setter
    private User user;


}
