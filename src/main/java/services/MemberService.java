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

    public String addMember(HttpServletRequest req) {
        try {
            Member member = this.getFromReq(req);

            //On vérifie que le nombre max de personnes dans la classe n'est pas dépassé :

            List<Member> memberList = memberDao.getAllMembersByClass(member.getClasse().getId());
            if(memberList.size()>=member.getClasse().getNmembres()){
                return "cette classe est déja pleine";
            }
            else {
                memberDao.addMember(member);
                return "ok";
            }


        }catch (SQLException e){
            return "cet email existe déjà";
        }
    }

    public void deleteMember(HttpServletRequest req) {
        try {
            int idToDelete = Integer.parseInt(req.getParameter("id"));
            memberDao.deleteMember(idToDelete);
        }catch (SQLException e){

        }
    }

    public String updateMember(HttpServletRequest req) {
        try {
            Member member = this.getFromReq(req);
            memberDao.updateMember(member);
            return "ok";
        }catch (SQLException e){
            return "cet email existe déjà";
        }
    }

    private Member getFromReq(HttpServletRequest req) {
        try {
            String idStr = req.getParameter("id");
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String birthdate = req.getParameter("birthdate");
            String className = req.getParameter("classname");

            Class classe = classDAO.getClass(className);
            Member member;

            System.out.println(className);
            if(idStr!=null){
                int id= Integer.parseInt(idStr);
                member = new Member(id, name, email, birthdate, classe);
            }else{
                member = new Member(name, email, birthdate, classe);
            }
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
