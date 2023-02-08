package services;

import dao.MemberDao;
import dao.MemberDaoImpl;

import javax.servlet.http.HttpServletRequest;

public class ClassService {

    private MemberDao memberDao = new MemberDaoImpl();
    private ClassDAO classDAO = new ClassDAO();
    public void addClass(HttpServletRequest req) {

        Class classe = this.getFromReq(req);
        classDAO.addClass(classe);

    }

    private Class getFromReq(HttpServletRequest req){
        String name = req.getParameter("name");
        Class classe = new Class(name);

        return classe;
    }
}
