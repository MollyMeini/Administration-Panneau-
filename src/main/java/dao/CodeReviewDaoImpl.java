package dao;

import models.Class;
import models.CodeReview;

import java.util.ArrayList;
import java.util.List;

public class CodeReviewDaoImpl implements CodeReviewDao {

    //list is working as a database
    List<CodeReview> codeReviews;

    public CodeReviewDaoImpl(){
//        codeReviews = new ArrayList<CodeReview>();
//        Class teste = new Class("aaa", classId);
//        CodeReview codeReview1 = new CodeReview("Robert","test","05/02/1997",teste);
//        CodeReview codeReview2 = new CodeReview("John","test2","15/02/1988",teste);
//        codeReviews.add(codeReview1);
//        codeReviews.add(codeReview2);
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
    public CodeReview getCodeReview(String name) {
        for(CodeReview aCodeReview : codeReviews){
            if (aCodeReview.getName().equals(name)){
                return aCodeReview;
            }
        }
        return null;
    }

    @Override
    public void addCodeReview(CodeReview codeReview) {
        boolean flag = false;
        for(CodeReview aCodeReview : codeReviews) {
            if (aCodeReview.getName().equals(codeReview.getName())) {
                System.out.println("Code Review: " + aCodeReview.getName() + ", already exists in the database");
                flag = true;
            }
        }
        if (!flag){
            codeReviews.add(codeReview);
        }
    }

    @Override
    public void updateCodeReview(CodeReview codeReview, String name, String description, String datetime, Class classe) {
        boolean flag = false;
        for(CodeReview aCodeReview : codeReviews) {
            if (aCodeReview.getId() != codeReview.getId() && aCodeReview.getDatetime().equals(datetime) && aCodeReview.getClasse().equals(classe)) {
                System.out.println("Error : Code Review - " + name + " - already exists in the database");
                flag = true;
            }
        }
        if (!flag){
            codeReviews.get(codeReview.getId()).setName(name);
            codeReviews.get(codeReview.getId()).setDescription(description);
            codeReviews.get(codeReview.getId()).setDatetime(datetime);
            codeReviews.get(codeReview.getId()).setClasse(classe);
            System.out.println("Code Review: Id " + codeReview.getId() + ", updated in the database");
        }
    }

    @Override
    public void deleteCodeReview(CodeReview codeReview) {
        boolean flag = false;
        for(CodeReview aCodeReview : codeReviews) {
            if (aCodeReview.getId() == codeReview.getId() && aCodeReview.getName().equals(codeReview.getName())) {
                codeReviews.remove(aCodeReview.getId());
                System.out.println("Code Review: Id " + aCodeReview.getId() + ", deleted from database");
                flag = true;
            }
        }
        if (!flag){
            System.out.println("Code Review: " + codeReview.getName() + ", not found in the database");
        }
    }
}