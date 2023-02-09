package dao;

import models.Class;
import models.CodeReview;
import utils.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CodeReviewDaoImpl implements CodeReviewDao {

    static Connection con = DbConnection.getConnection();

    private ClassDao classDao=new ClassDaoImpl();

    @Override
    public void addCodeReview(CodeReview codeReview) throws SQLException {
        String query = "insert into codereview (cr_name, cr_description, member_birthdate, class_id) VALUES (?,?,?,?)";
        PreparedStatement ps  = con.prepareStatement(query);
        ps.setString(1, codeReview.getName());
        ps.setString(2, codeReview.getDescription());
        ps.setString(3, codeReview.getDatetime());
        ps.setInt(4, codeReview.getClasse().getId());
        ps.executeUpdate();
    }

    @Override
    public void deleteCodeReview(int id) throws SQLException {
        String query= "delete from member where cr_id =?";
        PreparedStatement ps= con.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public CodeReview getCodeReview(int id) throws SQLException {
        return null;
    }

    @Override
    public List<CodeReview> getAllCodeReview() throws SQLException {
        return null;
    }

    @Override
    public void updateCodeReview(CodeReview codeReview) throws SQLException {

    }


//    @Override
//    public List<CodeReview> getAllCodeReview() {
//        return codeReviews;
//    }
//
//    @Override
//    public CodeReview getCodeReview(int id) {
//        return codeReviews.get(id);
//    }
//
//    @Override
//    public CodeReview getCodeReview(String name) {
//        for(CodeReview aCodeReview : codeReviews){
//            if (aCodeReview.getName().equals(name)){
//                return aCodeReview;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public void addCodeReview(CodeReview codeReview) {
//        boolean flag = false;
//        for(CodeReview aCodeReview : codeReviews) {
//            if (aCodeReview.getName().equals(codeReview.getName())) {
//                System.out.println("Code Review: " + aCodeReview.getName() + ", already exists in the database");
//                flag = true;
//            }
//        }
//        if (!flag){
//            codeReviews.add(codeReview);
//        }
//    }
//
//    @Override
//    public void updateCodeReview(CodeReview codeReview, String name, String description, String datetime, Class classe) {
//        boolean flag = false;
//        for(CodeReview aCodeReview : codeReviews) {
//            if (aCodeReview.getId() != codeReview.getId() && aCodeReview.getDatetime().equals(datetime) && aCodeReview.getClasse().equals(classe)) {
//                System.out.println("Error : Code Review - " + name + " - already exists in the database");
//                flag = true;
//            }
//        }
//        if (!flag){
//            codeReviews.get(codeReview.getId()).setName(name);
//            codeReviews.get(codeReview.getId()).setDescription(description);
//            codeReviews.get(codeReview.getId()).setDatetime(datetime);
//            codeReviews.get(codeReview.getId()).setClasse(classe);
//            System.out.println("Code Review: Id " + codeReview.getId() + ", updated in the database");
//        }
//    }
//
//    @Override
//    public void deleteCodeReview(CodeReview codeReview) {
//        boolean flag = false;
//        for(CodeReview aCodeReview : codeReviews) {
//            if (aCodeReview.getId() == codeReview.getId() && aCodeReview.getName().equals(codeReview.getName())) {
//                codeReviews.remove(aCodeReview.getId());
//                System.out.println("Code Review: Id " + aCodeReview.getId() + ", deleted from database");
//                flag = true;
//            }
//        }
//        if (!flag){
//            System.out.println("Code Review: " + codeReview.getName() + ", not found in the database");
//        }
//    }
}