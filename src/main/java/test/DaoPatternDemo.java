package test;

import dao.MemberDao;
import dao.MemberDaoImpl;
import models.Member;

public class DaoPatternDemo {
    public static void main(String[] args) {
        MemberDao memberDao = new MemberDaoImpl();

        //print all members
        for (Member member : memberDao.getAllMembers()) {
            System.out.println("Member: [Id : " + member.getId() + ", Name : " + member.getName() + " ]");
        }


        //update member
        Member member = memberDao.getAllMembers().get(0);
        member.setName("Michael");
        memberDao.updateMember(member);

        //get the member
        memberDao.getMember(0);
        System.out.println("Member: [Id : " + member.getId() + ", Name : " + member.getName() + " ]");
    }
}