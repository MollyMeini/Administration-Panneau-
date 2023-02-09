package dao;

import models.Class;
import models.CodeReview;

import java.sql.SQLException;
import java.util.List;

public interface CodeReviewDao {
    void addCodeReview(CodeReview codeReview) throws SQLException;
    void deleteCodeReview(int id) throws SQLException;
    CodeReview getCodeReview(int id) throws SQLException;
    List<CodeReview> getAllCodeReview() throws SQLException;
    void updateCodeReview(CodeReview codeReview) throws SQLException;
}