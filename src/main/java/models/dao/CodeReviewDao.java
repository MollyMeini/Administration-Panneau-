import java.util.List;

public interface CodeReviewDao {
    public List<CodeReview> getAllCodeReview();
    public Student getCodeReview(int id);
    public void updateCodeReview(CodeReview codeReview);
    public void deleteStudent(CodeReview codeReview);
}