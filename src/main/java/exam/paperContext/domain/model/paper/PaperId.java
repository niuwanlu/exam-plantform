package exam.paperContext.domain.model.paper;

import exam.paperContext.domain.shared.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class PaperId implements ValueObject<PaperId> {
    private String id;

    public static PaperId nextId() {
        UUID uuid = UUID.randomUUID();
        return new PaperId("paper-" + uuid);
    }

    @Override
    public boolean sameValueAs(PaperId other) {
        return equals(other);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaperId paperId = (PaperId) o;
        return Objects.equals(id, paperId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return id;
    }
}
