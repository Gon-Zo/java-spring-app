package com.app.api.service.qusetion;

import com.app.api.core.error.exception.BusinessException;
import com.app.api.core.error.exception.ErrorCode;
import com.app.api.domain.image.ImageRepository;
import com.app.api.domain.question.Question;
import com.app.api.domain.question.QuestionRepository;
import com.app.api.domain.question.support.QuestionSupport;
import com.app.api.domain.user.UserRepository;
import com.app.api.enums.Types;
import com.app.api.web.dto.ImageResponseDto;
import com.app.api.web.dto.PageableDto;
import com.app.api.web.dto.QustionResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import static com.app.api.utils.ApiDomainUtils.isNotEmpty;

@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService{

    private final QuestionSupport support;

    private final QuestionRepository repository;

    private final UserRepository userRepository;

    private final ImageRepository imageRepository;

    @Override
    public Page<Question> getPageQuestion(PageableDto dto){
       return support.findByPage(dto) ;
    }

    @Override
    @Transactional
    public void removeQuestion(long seq) {
        repository.deleteById(seq);
    }

    @Override
    @Transactional
    public void updateQuestion(long seq, QustionResponseDto dto) {
        support.update(seq , dto);
    }

    @Override
    public void createQuestion(QustionResponseDto dto) {

        dto.setUser(
                userRepository
                        .findById(dto.getUserSeq())
                        .orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND))
        );

        Question question = repository.saveAndFlush(dto.toEntity());

        Long seq = question.getSeq();

        if (isNotEmpty(dto.getImageVals())) {

            dto.getImageVals().stream()
                    .forEach(f -> imageRepository.save(
                            ImageResponseDto.builder()
                                    .photo(f)
                                    .dataId(seq)
                                    .type(Types.question.getValue())
                                    .build()
                                    .toEntity()
                    ));


        }

    }

    @Override
    public Question getQuestion(long seq) {
        return repository.findById(seq)
                .orElseThrow(() -> new BusinessException(ErrorCode.QUESTION_NOT_FOUND));
    }

}
