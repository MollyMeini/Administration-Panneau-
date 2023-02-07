package dao;

import models.CodeReview;

import java.util.List;

public interface CodeReviewDao {
    public List<CodeReview> getAllCodeReview();
    public CodeReview getCodeReview(int id);
    public void updateCodeReview(CodeReview codeReview);
    public void deleteStudent(CodeReview codeReview);
}