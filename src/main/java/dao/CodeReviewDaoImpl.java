package dao;

import dao.CodeReviewDao;
import models.Class;
import models.CodeReview;

import java.util.ArrayList;
import java.util.List;

public class CodeReviewDaoImpl implements CodeReviewDao {

    //list is working as a database
    List<CodeReview> codeReviews;

    public CodeReviewDaoImpl(){
        codeReviews = new ArrayList<CodeReview>();
        Class teste = new Class("aaa");
        CodeReview codeReview1 = new CodeReview("Robert","test","05/02/1997",teste);
        CodeReview codeReview2 = new CodeReview("John","test2","15/02/1988",teste);
        codeReviews.add(codeReview1);
        codeReviews.add(codeReview2);
    }

    @Override
    public List<CodeReview> getAllCodeReview() {
        return codeReviews;
    }

    @Override
    public CodeReview getCodeReview(int id) {
        return codeReviews.get(id);
    }

    @Override
    public void updateCodeReview(CodeReview codeReview) {
        codeReviews.get(codeReview.getId()).setName(codeReview.getName());
        System.out.println("Code Review: Id " + codeReview.getId() + ", updated in the database");
    }

    @Override
    public void deleteStudent(CodeReview codeReview) {
        codeReviews.remove(codeReview.getId());
        System.out.println("Code Review: Id " + codeReview.getId() + ", deleted from database");
    }
}