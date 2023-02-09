package dao;

import models.Class;
import models.Member;

import java.sql.SQLException;
import java.util.List;

public interface MemberDao {
    void addMember(Member member) throws SQLException;
    void deleteMember(int id) throws SQLException;
    Member getMember(String email) throws SQLException;
    Member getMember(int id) throws SQLException;
    List<Member> getAllMembers() throws SQLException;
    List<Member> getAllMembersByClass(int classId) throws SQLException;
    void updateMember(Member member) throws SQLException;
}