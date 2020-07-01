package exam.blankQuizContext.domain.model.blankQuiz;

import exam.paperContext.domain.shared.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlankQuizId blankQuizId = (BlankQuizId) o;
        return Objects.equals(id, blankQuizId.id);
    }

    @Override
    public String toString() {
        return id;
    }
}
