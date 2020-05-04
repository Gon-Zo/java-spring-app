package com.app.api.web.dto;

import com.app.api.domain.user.User;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor
public class QustionResponseDto {

   private String title;

   private String content;

   private Boolean isLock;

   private long userSeq;

   @Setter
   private User user;

   @Builder
   public QustionResponseDto(String title, String content, Boolean isLock, long userSeq) {
      this.title = title;
      this.content = content;
      this.isLock = isLock;
      this.userSeq = userSeq;
   }

}
