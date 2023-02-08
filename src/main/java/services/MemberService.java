package services;

import dao.MemberDao;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class MemberService {

    private MemberDao memberDao = new MemberDAO();
    private ClassDAO classDAO = new ClassDAO();
    public void addMember(HttpServletRequest req) {

        Member member = this.getFromReq(req);
        memberDao.addMember(member);

    }

    private Member getFromReq(HttpServletRequest req){
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String birthdate = req.getParameter("birthdate");
        String className = req.getParameter("class");

        Class classe = classDAO.getByName(className);

        Member member = new Member(name, email, birthdate, classe);

        return member;
    }
}
