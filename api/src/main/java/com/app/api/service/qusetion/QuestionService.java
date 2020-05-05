package com.app.api.service.qusetion;

import com.app.api.domain.question.Question;
import com.app.api.web.dto.PageableDto;
import com.app.api.web.dto.QustionResponseDto;
import org.springframework.data.domain.Page;

public interface QuestionService {

    Page<Question> getPageQuestion(PageableDto dto);

    void removeQuestion(long seq);

    void updateQuestion(QustionResponseDto dto);

    void createQuestion(QustionResponseDto dto);

}
