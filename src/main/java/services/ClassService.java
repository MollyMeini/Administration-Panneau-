package services;

import dao.ClassDao;
import dao.ClassDaoImpl;
import models.Class;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class ClassService {

    private ClassDao classDAO = new ClassDaoImpl();

    public String addClass(HttpServletRequest req) {
        try {
            Class classe = this.getFromReq(req);
            classDAO.addClass(classe);
            return "ok";
        }catch (SQLException e){
            System.out.println("aaa");
            return "ce nom de classe existe déjà";
        }
    }

    public void deleteClass(HttpServletRequest req) {
        try {
            int idToDelete = Integer.parseInt(req.getParameter("id"));
            classDAO.deleteClass(idToDelete);
        }catch (SQLException e){
            System.out.println("bbb");
        }
    }

    public void updateClass(HttpServletRequest req) {
        try {
            Class classe = this.getFromReq(req);
            classDAO.updateClass(classe);
        }catch (SQLException e){
            System.out.println("ccc");
        }
    }

    private Class getFromReq(HttpServletRequest req) {
        String name = req.getParameter("classname");
        String memberStr = req.getParameter("member");
        int member=0;
        if (!memberStr.equals("")){
            member=Integer.parseInt(memberStr);
        }
        Class classe = new Class(name, member);

        return classe;
    }

    public List<Class> getAllClasses() {
        try {
            List<Class> ls = classDAO.getAllClasses();
            return ls;
        } catch (SQLException e) {
            return null;
        }
    }
}
