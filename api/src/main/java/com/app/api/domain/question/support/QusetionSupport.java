package com.app.api.domain.question.support;

import com.app.api.domain.question.Question;
import com.app.api.web.dto.PageableDto;
import org.springframework.data.domain.Page;

public interface QusetionSupport{

    Page<Question> findByPage(PageableDto dto);
}
