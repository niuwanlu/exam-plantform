package exam.blankQuizContext.domain.model.blankQuiz;

import exam.paperContext.domain.shared.Entity;

import java.time.LocalDateTime;

public class BlankQuiz implements Entity<BlankQuiz> {
    private BlankQuizId blankQuizId;
    private String teacherId;
    private String content;
    private String referenceAnswer;
    private int score;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

    public BlankQuiz(BlankQuizId blankQuizId, String teacherId, String content, String referenceAnswer, int score) {
        this.blankQuizId = blankQuizId;
        this.teacherId = teacherId;
        this.content = content;
        this.referenceAnswer = referenceAnswer;
        this.score = score;
        this.createdTime = LocalDateTime.now();
        this.updatedTime = LocalDateTime.now();
    }

    public static BlankQuiz create(BlankQuizId blankQuizId, String teacherId, String content, String referenceAnswer, int score) {
        return new BlankQuiz(blankQuizId, teacherId, content, referenceAnswer, score);
    }

    @Override
    public boolean sameIdentityAs(BlankQuiz other) {
        return false;
    }
}
