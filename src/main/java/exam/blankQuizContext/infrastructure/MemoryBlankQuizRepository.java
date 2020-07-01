package exam.blankQuizContext.infrastructure;

import exam.blankQuizContext.domain.model.blankQuiz.BlankQuiz;
import exam.blankQuizContext.domain.model.blankQuiz.BlankQuizId;
import exam.blankQuizContext.domain.model.blankQuiz.BlankQuizRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class MemoryBlankQuizRepository implements BlankQuizRepository {
    private Set<BlankQuiz> blankquizzes = new HashSet<BlankQuiz>();

    @Override
    public void save(BlankQuiz blankQuiz) {
        blankquizzes.add(blankQuiz);
    }

    @Override
    public List<BlankQuiz> getAll() {
        return new ArrayList<>(blankquizzes);
    }

    @Override
    public BlankQuiz find(BlankQuizId blankQuizId) {
        return blankquizzes.stream()
                .filter(blankQuiz -> blankQuiz.getBlankQuizId().equals(blankQuizId))
                .findFirst()
                .orElseThrow(NullPointerException::new);
    }
}
