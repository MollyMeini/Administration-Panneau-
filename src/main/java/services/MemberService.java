package services;

import dao.ClassDao;
import dao.ClassDaoImpl;
import dao.MemberDao;
import dao.MemberDaoImpl;
import models.Class;
import models.CodeReview;
import models.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class MemberService {

    private MemberDao memberDao = new MemberDaoImpl();
    private ClassDao classDAO = new ClassDaoImpl();

    public void addMember(HttpServletRequest req) {
        try {
            Member member = this.getFromReq(req);
            memberDao.addMember(member);
        }catch (SQLException e){

        }
    }

    public void deleteMember(HttpServletRequest req) {
        try {
            int idToDelete = Integer.parseInt(req.getParameter("id"));
            memberDao.deleteMember(idToDelete);
        }catch (SQLException e){

        }
    }

    public void updateMember(HttpServletRequest req) {
        try {
            Member member = this.getFromReq(req);
            memberDao.updateMember(member);
        }catch (SQLException e){

        }
    }

    private Member getFromReq(HttpServletRequest req) {
        try {
            String id  = req.getParameter("id");
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String birthdate = req.getParameter("birthdate");
            String className = req.getParameter("classname");

            Class classe = classDAO.getClass(className);
            Member member = new Member(id, name, email, birthdate, classe);

            return member;
        }catch (SQLException e){
            return null;
        }
    }

    public List<Member> getAllMembers() {
        try {
            List<Member> lm = memberDao.getAllMembers();
            return lm;
        } catch (SQLException e) {
            return null;
        }
    }

    public Member getMember(int id) throws SQLException {
        return memberDao.getMember(id);
    }
}
