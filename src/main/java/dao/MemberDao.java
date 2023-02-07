package dao;

import models.Member;

import java.util.List;

public interface MemberDao {
    public List<Member> getAllMembers();
    public Member getMember(int id);
    public void updateMember(Member member);
    public void deleteMember(Member member);
}