package services;

import dao.*;
import models.Class;
import models.CodeReview;

import javax.servlet.http.HttpServletRequest;

public class CodeReviewService {

    private MemberDao memberDao = new MemberDaoImpl();
    private ClassDao classDAO = new ClassDaoImpl();

    private CodeReviewDao codeReviewDAO = new CodeReviewDaoImpl();

    public void addCodeReview(HttpServletRequest req) {

        CodeReview cr = this.getFromReq(req);
        codeReviewDAO.addCodeReview(cr);

    }

    public void deleteCodeReview(HttpServletRequest req){
        CodeReview cr = this.getFromReq(req);
        codeReviewDAO.deleteCodeReview(cr);
    }

    public void updateCodeReview(HttpServletRequest req){
        CodeReview cr = this.getFromReq(req);
        codeReviewDAO.updateCodeReview(cr, cr.getName(), cr.getDescription(), cr.getDatetime(), cr.getClasse());
    }

    private CodeReview getFromReq(HttpServletRequest req){
        String name = req.getParameter("name");
        String desc = req.getParameter("description");
        String date = req.getParameter("date");
        String className = req.getParameter("class");

        Class classe = classDAO.getClass(className);

        CodeReview cr = new CodeReview(name, desc, date, classe);

        return cr;
    }
}
