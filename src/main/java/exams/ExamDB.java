package exams;

import java.util.ArrayList;
import java.util.List;

public class ExamDB {

    private List<Exam> exams = new ArrayList<>();

    public void addExam(Exam exam, int actPoint) {
        exam.calculateExamResult(actPoint);
        exams.add(exam);
    }

    public List<Exam> getExams() {
        return List.copyOf(exams);
    }

    public int countPassedExams() {
        return (int) exams.stream()
                .filter(e -> !e.getExamResult().equals(ExamResult.NOT_PASSED))
                .toList()
                .stream().count();
    }

    public List<Exam> findById(long id) {
        return exams.stream()
                .filter(e -> e.getStudentId() == id)
                .toList();
    }

    public List<String> findTopicByPrefix(String pref) {
        return exams.stream()
                .map(e -> e.getTopic())
                .filter(s -> s.contains(pref))
                .toList();
    }
}
