package services;

import dao.ClassDao;
import dao.ClassDaoImpl;
import dao.MemberDao;
import dao.MemberDaoImpl;
import models.Class;

import javax.servlet.http.HttpServletRequest;

public class ClassService {

    private MemberDao memberDao = new MemberDaoImpl();
    private ClassDao classDAO = new ClassDaoImpl();

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
