package exam.blankQuizContext.userInterface;

import exam.blankQuizContext.application.BlankQuizApplicationService;
import exam.blankQuizContext.application.CreateBlankQuizCommand;
import exam.blankQuizContext.domain.model.blankQuiz.BlankQuiz;
import exam.blankQuizContext.domain.model.blankQuiz.BlankQuizId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlankQuizController {

    private BlankQuizApplicationService blankQuizApplicationService;

    @Autowired
    public BlankQuizController(BlankQuizApplicationService blankQuizApplicationService) {
        this.blankQuizApplicationService = blankQuizApplicationService;
    }

    @PostMapping("/blankquizzes")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    BlankQuizDTO create(@RequestBody CreateBlankQuizCommand command) {
        final BlankQuizId blankQuizId = blankQuizApplicationService.createBlankQuiz(command);
        return BlankQuizDTO.from(blankQuizId);
    }

    @GetMapping("/blankquizzes")
    List<BlankQuiz> getAll() {
        return blankQuizApplicationService.getAllBlankQuizzes();
    }

    @GetMapping("/blankquizzes/{blankquizId}")
    BlankQuiz getById(@PathVariable String blankquizId) {
        return blankQuizApplicationService.getBlankQuiz(blankquizId);
    }

    @PutMapping("/blankquizzes/{blankquizId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void revise(@PathVariable String blankquizId, @RequestBody CreateBlankQuizCommand command) {
        blankQuizApplicationService.reviseBlankQuiz(blankquizId, command);
    }

}
