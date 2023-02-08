package services;

import dao.ClassDao;
import dao.ClassDaoImpl;
import dao.MemberDao;
import dao.MemberDaoImpl;
import models.Class;

import javax.servlet.http.HttpServletRequest;

public class ClassService {

    //private MemberDao memberDao = new MemberDaoImpl();
    private ClassDao classDAO = new ClassDaoImpl();

    public void addClass(HttpServletRequest req) {

        Class classe = this.getFromReq(req);
//        System.out.println(classe.getName());
//        System.out.println(classe.getnMembers());
        classDAO.addClass(classe);

    }

    private Class getFromReq(HttpServletRequest req){
        String name = req.getParameter("classname");
        int member = Integer.parseInt(req.getParameter("member"));
//        System.out.println(name);
//        System.out.println(member);
        Class classe = new Class(name, member);

        return classe;
    }
}
