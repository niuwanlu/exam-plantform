package exam.blankQuizContext.domain.model.blankQuiz;

import java.util.List;

public interface BlankQuizRepository {
    void save(BlankQuiz blankQuiz);

    List<BlankQuiz> getAll();

    BlankQuiz find(BlankQuizId blankQuizId);

    void delete(BlankQuizId blankQuizId);
}
