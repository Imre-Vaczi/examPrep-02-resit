package exams;

public class MultipleChoiceExam extends Exam{

    public MultipleChoiceExam(long studentId, String topic, int maxPoints) {
        super(studentId, topic, maxPoints);
    }

    public MultipleChoiceExam(long studentId, String topic) {
        super(studentId, topic);

    }

    @Override
    public void calculateExamResult(int actualPoints) {
        if (actualPoints < 0 | actualPoints > getMaxPoints()) {
            throw new IllegalArgumentException("Invalid actualPoints");
        }
        int result = (int) ((actualPoints / (getMaxPoints() * 1.0)) * 100);
        if (result < 51) {
            setExamResult(ExamResult.NOT_PASSED);
        } else {
            setExamResult(ExamResult.PASSED);
        }
    }

}
