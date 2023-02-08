package dao;

import models.Class;
import models.CodeReview;

import java.util.List;

public interface CodeReviewDao {
    public List<CodeReview> getAllCodeReview();
    public CodeReview getCodeReview(int id);
    public CodeReview getCodeReview(String name);
    public void addCodeReview(CodeReview codeReview);
    public void updateCodeReview(CodeReview codeReview, String name, String description, String datetime, Class classe);
    public void deleteCodeReview(CodeReview codeReview);
}