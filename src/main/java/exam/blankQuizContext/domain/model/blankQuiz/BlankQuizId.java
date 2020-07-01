package exam.blankQuizContext.domain.model.blankQuiz;

import exam.paperContext.domain.shared.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class BlankQuizId implements ValueObject<BlankQuizId> {
    private String id;

    public static BlankQuizId nextId() {
        UUID uuid = UUID.randomUUID();
        return new BlankQuizId("blankquiz-" + uuid);
    }

    @Override
    public boolean sameValueAs(BlankQuizId other) {
        return equals(other);
    }

    @Override
    public String toString() {
        return id;
    }
}
