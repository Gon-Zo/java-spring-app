package com.app.api.web.dto;

import com.app.api.domain.notice.Notice;
import com.app.api.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class NoticeResponseDto {

    private String title;

    private String content;

    private Long userSeq;

    @Setter
    private User user;

    public Notice toEntity(){
        return Notice.builder()
                .title(this.title)
                .content(this.content)
                .user(user)
                .build();
    }

}
