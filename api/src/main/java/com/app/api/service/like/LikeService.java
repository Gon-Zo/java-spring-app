package com.app.api.service.like;

import com.app.api.web.dto.LikeResponseDto;

public interface LikeService {

   void saveBy(LikeResponseDto dto);

   void deleteBy(long seq);

}
