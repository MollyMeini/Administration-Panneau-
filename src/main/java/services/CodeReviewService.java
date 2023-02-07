package Services;

import javax.servlet.http.HttpServletRequest;

public class CodeReviewService {

    private MemberDao memberDao = new MemberDAO();
    private ClassDAO classDAO = new ClassDAO();

    private CodeReviewDAO codeReviewDAO = new CodeReviewDAO();
    public void addCodeReview(HttpServletRequest req) {

        CodeReview cr = this.getFromReq(req);
        codeReviewDAO.addCodeReview(cr);

    }

    public void deleteCodeReview(){} //TODO juste id ?

    public void updateCodeReview(HttpServletRequest req){
        CodeReview cr = this.getFromReq(req);
        codeReviewDAO.updateCodeReview(cr);
    }

    private CodeReview getFromReq(HttpServletRequest req){
        String name = req.getParameter("name");
        String desc = req.getParameter("description");
        String date = req.getParameter("date");
        String className = req.getParameter("class");

        Class classe = classDAO.getByName(className);

        CodeReview cr = new CodeReview(name, desc, date, classe);

        return cr;
    }
}
