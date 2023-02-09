package dao;

import models.Class;
import models.Member;

import java.sql.SQLException;
import java.util.List;

public interface MemberDao {
    void addMember(Member member) throws SQLException;

    void deleteMember(int id) throws SQLException;

    Member getMember(int id) throws SQLException;

    List<Member> getAllMembers() throws SQLException;

    List<Member> getAllMembersByClass(int classId) throws SQLException;

    void updateMember(Member member) throws SQLException;
//    public List<Member> getAllMembers();
//    public Member getMember(int id);
//    public Member getMember(String name);
//    public void addMember(Member member);
//    public void updateMember(Member member, String name, String email, String birthdate, Class classe);
//    public void deleteMember(Member member);
}