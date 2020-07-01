package exam.blankQuizContext.infrastructure;

import exam.blankQuizContext.domain.model.blankQuiz.BlankQuiz;
import exam.blankQuizContext.domain.model.blankQuiz.BlankQuizRepository;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class MemoryBlankQuizRepository implements BlankQuizRepository {
    private Set<BlankQuiz> blankQuizs = new HashSet<BlankQuiz>();

    @Override
    public void save(BlankQuiz blankQuiz) {
        blankQuizs.add(blankQuiz);
    }
}
