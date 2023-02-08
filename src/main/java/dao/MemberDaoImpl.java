package dao;

import models.Class;
import models.CodeReview;
import models.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberDaoImpl implements MemberDao {

    //list is working as a database
    private List<Member> members;

    public MemberDaoImpl(){
        members = new ArrayList<Member>();
        Class teste = new Class("aaa");
        Member member1 = new Member("Robert","test","12/05/2015",teste);
        Member member2 = new Member("John","test2","12/05/2015",teste);
        members.add(member1);
        members.add(member2);
    }

    @Override
    public List<Member> getAllMembers() {
        return members;
    }

    @Override
    public Member getMember(int id) {
        return members.get(id);
    }

    @Override
    public Member getMember(String name) {
        for(Member aMember : members){
            if (aMember.getName().equals(name)){
                return aMember;
            }
        }
        return null;
    }

    @Override
    public void addMember(Member member) {
        boolean flag = false;
        for(Member aMember : members) {
            if (aMember.getEmail().equals(member.getEmail())) {
                System.out.println("Error : Member " + aMember.getName() + " email already exists in the database");
                flag = true;
            }
        }
        if (!flag){
            members.add(member);
        }
    }

    @Override
    public void updateMember(Member member, String name, String email, String birthdate, Class classe) {
        boolean flag = false;
        for(Member aMember : members) {
            if (aMember.getEmail().equals(email) && aMember.getId() != member.getId()) {
                System.out.println("Error : Member " + name + " email already exists in the database");
                flag = true;
            }
        }
        if (!flag){
            members.get(member.getId()).setName(name);
            members.get(member.getId()).setEmail(email);
            members.get(member.getId()).setBirthdate(birthdate);
            members.get(member.getId()).setClasse(classe);
            System.out.println("Member: Id " + member.getId() + ", updated in the database");
        }
    }

    @Override
    public void deleteMember(Member member) {
        boolean flag = false;
        for(Member aMember : members) {
            if (aMember.getId() == member.getId() && aMember.getName().equals(member.getName()) && aMember.getEmail().equals(member.getEmail())) {
                members.remove(aMember.getId());
                System.out.println("Member: Id " + aMember.getId() + ", deleted from database");
                flag = true;
            }
        }
        if (!flag){
            System.out.println("Member: " + member.getName() + ", not found in the database");
        }
    }
}