package dao;

import models.Class;
import models.Member;

import java.util.List;

public interface MemberDao {
    public List<Member> getAllMembers();
    public Member getMember(int id);
    public Member getMember(String name);
    public void addMember(Member member);
    public void updateMember(Member member, String name, String email, String birthdate, Class classe);
    public void deleteMember(Member member);
}