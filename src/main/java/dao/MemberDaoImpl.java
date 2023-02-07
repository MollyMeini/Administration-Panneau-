package dao;

import models.Class;
import models.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberDaoImpl implements MemberDao {

    //list is working as a database
    List<Member> members;

    public MemberDaoImpl(){
        members = new ArrayList<Member>();
        Class teste = new Class("aaa");
        Member member1 = new Member("Robert","test","12/05/2015",teste);
        Member member2 = new Member("John","test2","12/05/2015",teste);
        members.add(member1);
        members.add(member2);
    }
    @Override
    public void deleteMember(Member member) {
        members.remove(member.getId());
        System.out.println("Member: Id " + member.getId() + ", deleted from database");
    }

    //retrive list of students from the database
    @Override
    public List<Member> getAllMembers() {
        return members;
    }

    @Override
    public Member getMember(int id) {
        return members.get(id);
    }

    @Override
    public void updateMember(Member member) {
        members.get(member.getId()).setName(member.getName());
        System.out.println("Member: Id " + member.getId() + ", updated in the database");
    }
}