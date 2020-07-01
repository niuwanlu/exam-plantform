package exam.blankQuizContext.userInterface;

import exam.blankQuizContext.application.BlankQuizApplicationService;
import exam.blankQuizContext.application.CreateBlankQuizCommand;
import exam.blankQuizContext.domain.model.blankQuiz.BlankQuizId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlankQuizController {

    private BlankQuizApplicationService blankQuizApplicationService;

    @Autowired
    public BlankQuizController(BlankQuizApplicationService blankQuizApplicationService) {
        this.blankQuizApplicationService = blankQuizApplicationService;
    }

    @PostMapping("/blankquizs")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    BlankQuizDTO create(@RequestBody CreateBlankQuizCommand command) {
        final BlankQuizId blankQuizId = blankQuizApplicationService.createBlankQuiz(command);
        return BlankQuizDTO.from(blankQuizId);
    }
}
