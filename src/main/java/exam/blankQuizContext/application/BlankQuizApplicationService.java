package exam.blankQuizContext.application;

import exam.blankQuizContext.domain.model.blankQuiz.BlankQuiz;
import exam.blankQuizContext.domain.model.blankQuiz.BlankQuizId;
import exam.blankQuizContext.domain.model.blankQuiz.BlankQuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlankQuizApplicationService {
    private BlankQuizRepository blankQuizRepository;

    @Autowired
    public BlankQuizApplicationService(BlankQuizRepository blankQuizRepository) {
        this.blankQuizRepository = blankQuizRepository;
    }

    public BlankQuizId createBlankQuiz(CreateBlankQuizCommand command) {
        BlankQuizId blankQuizId = BlankQuizId.nextId();
        BlankQuiz blankQuiz = BlankQuiz.create(blankQuizId, command.getTeacherId(), command.getContent(),
                command.getReferenceAnswer(), command.getScore());

        blankQuizRepository.save(blankQuiz);
        return blankQuizId;
    }

    public List<BlankQuiz> getAllBlankQuizzes() {
        return blankQuizRepository.getAll();
    }

    public BlankQuiz getBlankQuiz(String blankQuizId) {
        return blankQuizRepository.find(new BlankQuizId(blankQuizId));
    }

    public void reviseBlankQuiz(String blankQuizId, CreateBlankQuizCommand command) {
        BlankQuiz blankQuiz = blankQuizRepository.find(new BlankQuizId(blankQuizId));
        blankQuiz.revise(command.getTeacherId(), command.getContent(),
                command.getReferenceAnswer(), command.getScore());
    }
}
