package com.app.api.web.client;

import com.app.api.domain.question.Question;
import com.app.api.service.qusetion.QuestionService;
import com.app.api.web.dto.PageableDto;
import com.app.api.web.dto.QustionResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client/question")
public class ClientQuestionController {

    private final QuestionService service;

    public ClientQuestionController(QuestionService service) {
        this.service = service;
    }

    @GetMapping("")
    public Page<Question> showQuestions(PageableDto dto){
       return service.getPageQuestion(dto);
    }

    @PostMapping("")
    public void writeQuestion(QustionResponseDto dto){
       service.createQuestion(dto);
    }

    @PutMapping("/{seq}")
    public void reviseQuestion(@PathVariable long seq , QustionResponseDto dto){
        service.updateQuestion(seq, dto);
    }

    @DeleteMapping("/{seq}")
    public void removeQuestion(@PathVariable long seq){
        service.removeQuestion(seq);
    }

    @GetMapping("/{seq}")
    public Question showQuestion(@PathVariable long seq){
        return service.getQuestion(seq);
    }

}
