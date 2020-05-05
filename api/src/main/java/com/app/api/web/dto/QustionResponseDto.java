package com.app.api.web.dto;

import com.app.api.domain.question.Question;
import com.app.api.domain.user.User;
import lombok.*;

import java.util.List;

@Getter
@ToString
@NoArgsConstructor
public class QustionResponseDto {

   private String title;

   private String content;

   private Boolean isLock;

   private long userSeq;

   private List<String> imageVals;

   @Setter
   private User user;

   @Builder
   public QustionResponseDto(String title, String content, Boolean isLock, long userSeq) {
      this.title = title;
      this.content = content;
      this.isLock = isLock;
      this.userSeq = userSeq;
   }

   public Question toEntity(){
      return Question.builder()
              .title(title)
              .content(content)
              .isLock(isLock)
              .user(user)
              .build();
   }

}
