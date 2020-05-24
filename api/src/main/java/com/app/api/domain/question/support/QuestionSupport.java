package com.app.api.domain.question.support;

import com.app.api.domain.question.Question;
import com.app.api.web.dto.PageableDto;
import com.app.api.web.dto.QustionResponseDto;
import org.springframework.data.domain.Page;

public interface QuestionSupport {

    Page<Question> findByPage(PageableDto dto);

    void update(long seq, QustionResponseDto dto);

}
