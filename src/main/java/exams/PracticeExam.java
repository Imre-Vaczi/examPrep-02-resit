package exams;

import java.util.List;

public class PracticeExam  extends Exam{

    public PracticeExam(long studentId, String topic, List<Integer> pointsPerExercise) {
        super(studentId, topic);
        setMaxPoints(calculateMaxPoint(pointsPerExercise));
    }

    public PracticeExam(long studentId, String topic) {
        super(studentId, topic);
    }

    @Override
    public void calculateExamResult(int actualPoints) {
        int result = (int) ((actualPoints / (getMaxPoints() * 1.0)) * 100);
        if (result == 100) {
            setExamResult(ExamResult.PERFECT);
        } else if (result >= 76 & result < 100) {
            setExamResult(ExamResult.OK);
        } else if (result > 50 & result < 76) {
            setExamResult(ExamResult.PASSED);
        } else {
            setExamResult(ExamResult.NOT_PASSED);
        }
    }

    private int calculateMaxPoint(List<Integer> pointsPerExercise) {
        int result = pointsPerExercise.stream().mapToInt(c -> c).sum();
        if (result < 10 || result > 150) {
            throw new IllegalArgumentException("Maximum points should be between 10 and 150! Actual:" + result);
        }
        return result;
    }

    public static void main(String[] args) {
        PracticeExam pe = new PracticeExam(1,"Java", List.of(20,15,30,25));

    }
}
