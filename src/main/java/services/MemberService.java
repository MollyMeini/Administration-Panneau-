package services;

import dao.ClassDao;
import dao.ClassDaoImpl;
import dao.MemberDao;
import dao.MemberDaoImpl;
import models.Class;
import models.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.sql.SQLException;
import java.util.Date;

public class MemberService {

    private MemberDao memberDao = new MemberDaoImpl();
    private ClassDao classDAO = new ClassDaoImpl();
    public void addMember(HttpServletRequest req) throws SQLException {

        Member member = this.getFromReq(req);
        memberDao.addMember(member);

    }

    private Member getFromReq(HttpServletRequest req) throws SQLException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String birthdate = req.getParameter("birthdate");
        String className = req.getParameter("class");

        Class classe = classDAO.getClass(className);

        Member member = new Member(name, email, birthdate, classe);

        return member;
    }
}
