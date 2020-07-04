package exam.blankQuizContext.domain.model.blankQuiz;

import exam.paperContext.domain.shared.Entity;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(of = {"blankQuizId"})
public class BlankQuiz implements Entity<BlankQuiz> {
    private BlankQuizId blankQuizId;
    private String teacherId;
    private String content;
    private String referenceAnswer;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

    public BlankQuiz(BlankQuizId blankQuizId, String teacherId, String content, String referenceAnswer) {
        this.blankQuizId = blankQuizId;
        this.teacherId = teacherId;
        this.content = content;
        this.referenceAnswer = referenceAnswer;
        this.createdTime = LocalDateTime.now();
        this.updatedTime = LocalDateTime.now();
    }

    public static BlankQuiz create(BlankQuizId blankQuizId, String teacherId, String content, String referenceAnswer) {
        return new BlankQuiz(blankQuizId, teacherId, content, referenceAnswer);
    }

    public void revise(String teacherId, String content, String referenceAnswer) {
        this.teacherId = teacherId;
        this.content = content;
        this.referenceAnswer = referenceAnswer;
    }

    @Override
    public boolean sameIdentityAs(BlankQuiz other) {
        return false;
    }

    public BlankQuizId getBlankQuizId() {
        return this.blankQuizId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public String getContent() {
        return content;
    }

    public String getReferenceAnswer() {
        return referenceAnswer;
    }
}
