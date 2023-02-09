package services;

import dao.ClassDao;
import dao.ClassDaoImpl;
import dao.MemberDao;
import dao.MemberDaoImpl;
import models.Class;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class ClassService {

    private ClassDao classDAO = new ClassDaoImpl();

    public void addClass(HttpServletRequest req) throws SQLException {
        Class classe = this.getFromReq(req);
        classDAO.addClass(classe);
    }

    private Class getFromReq(HttpServletRequest req){
        String name = req.getParameter("classname");
        String memberStr = req.getParameter("member");
        int member=0;
        if (!memberStr.equals("")){
            member=Integer.parseInt(memberStr);
        }
        Class classe = new Class(name, member);

        return classe;
    }
}
