package services;

import dao.*;
import models.Class;
import models.CodeReview;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class CodeReviewService {

    private MemberDao memberDao = new MemberDaoImpl();
    private ClassDao classDAO = new ClassDaoImpl();
    private CodeReviewDao codeReviewDAO = new CodeReviewDaoImpl();

    public void addCodeReview(HttpServletRequest req) {
        try {
            CodeReview cr = this.getFromReq(req);
            codeReviewDAO.addCodeReview(cr);
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public void deleteCodeReview(HttpServletRequest req) {
        try {
            int idToDelete = Integer.parseInt(req.getParameter("id"));
            codeReviewDAO.deleteCodeReview(idToDelete);
        }catch (SQLException e){

        }
    }

    public void updateCodeReview(HttpServletRequest req) {
        try {
            CodeReview cr = this.getFromReq(req);
            codeReviewDAO.updateCodeReview(cr);
        }catch (SQLException e){

        }
    }

    private CodeReview getFromReq(HttpServletRequest req) {
        try {
            String name = req.getParameter("name");
            String desc = req.getParameter("description");
            String date = req.getParameter("datetime");
            String className = req.getParameter("classname");
            Class classe = classDAO.getClass(className);

            CodeReview cr = new CodeReview(name, desc, date, classe);

            return cr;
        }catch (SQLException e){

            return null;
        }
    }

    public List<CodeReview> getAllCodeReviews() {
        try {
            List<CodeReview> lc = codeReviewDAO.getAllCodeReview();
            return lc;
        } catch (SQLException e) {
            return null;
        }
    }
}
