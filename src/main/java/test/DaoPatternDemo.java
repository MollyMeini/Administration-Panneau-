package test;

import dao.MemberDao;
import dao.MemberDaoImpl;
import models.Member;

import java.util.List;

public class DaoPatternDemo {
    public static void main(String[] args) {
        MemberDao memberDao = new MemberDaoImpl();

        //print all members
        for (Member member : memberDao.getAllMembers()) {
            System.out.println("Member: [Id : " + member.getId() + ", Name : " + member.getName() + " ]");
        }


        //update member
        Member member = memberDao.getAllMembers().get(0);
        memberDao.updateMember(member,"Michael", member.getEmail(), member.getBirthdate(), member.getClasse());

        List<Member> members = memberDao.getAllMembers();
        for (Member aMember : members) {
            System.out.println("Member: [Id : " + aMember.getId() + ", Name : " + aMember.getName() + " ]");
        }

        memberDao.deleteMember(member);
        member = memberDao.getAllMembers().get(0);
        memberDao.updateMember(member,"Michael", member.getEmail(), member.getBirthdate(), member.getClasse());
        Member test = new Member("Andre","aaa@takima.fr","05/02/1997",member.getClasse());
        memberDao.addMember(test);

        //System.out.println("Member: [Id : " + member.getId() + ", Name : " + member.getName() + " ]");


        members = memberDao.getAllMembers();
        for (Member aMember : members) {
            System.out.println("Member: [Id : " + aMember.getId() + ", Name : " + aMember.getName() + " ]");
        }

    }
}