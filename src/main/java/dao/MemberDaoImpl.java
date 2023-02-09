package dao;

import models.Member;
import utils.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDaoImpl implements MemberDao {

    //list is working as a database
    private List<Member> members;

    private ClassDao classDao=new ClassDaoImpl();

    public MemberDaoImpl(){
//        members = new ArrayList<Member>();
//        Class teste = new Class("aaa", classId);
//        Member member1 = new Member("Robert","test","12/05/2015",teste);
//        Member member2 = new Member("John","test2","12/05/2015",teste);
//        members.add(member1);
//        members.add(member2);
    }


    static Connection con = DbConnection.getConnection();

    @Override
    public void addMember(Member member) throws SQLException {
//        System.out.println("aaaaaaaa");
        String query = "insert into member (member_name, member_mail, member_birthdate, class_id) VALUES (?,?,?,?)";
        PreparedStatement ps  = con.prepareStatement(query);
        ps.setString(1, member.getName());
        ps.setString(2, member.getEmail());
        ps.setString(3, member.getBirthdate());
        ps.setInt(4, member.getClasse().getId());
        ps.executeUpdate();
    }

    @Override
    public void deleteMember(int id) throws SQLException
    {
        String query= "delete from member where member_id =?";
        PreparedStatement ps= con.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public Member getMember(int id) throws SQLException {
        String query= "select * from member where member_id= ?";
        PreparedStatement ps= con.prepareStatement(query);
        ps.setInt(1, id);
        return getaMember(ps);
    }

    private Member getaMember(PreparedStatement ps) throws SQLException {
        Member member = new Member();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            member.setId(rs.getInt("member_id"));
            member.setName(rs.getString("member_name"));
            member.setEmail(rs.getString("member_mail"));
            member.setBirthdate(rs.getString("member_birthdate"));
            member.setClasse(classDao.getClass(rs.getInt("class_id")));
        }

        if (check == true) {
            return member;
        }
        else
            return null;
    }

    @Override
    public List<Member> getAllMembers() throws SQLException {
        String query = "select * from member";
        PreparedStatement ps= con.prepareStatement(query);
        return getMemberList(ps);
    }
    @Override
    public List<Member> getAllMembersByClass(int classId) throws SQLException {
        String query= "select * from member where class_id= ?";
        PreparedStatement ps= con.prepareStatement(query);
        ps.setInt(1, classId);
        return getMemberList(ps);
    }

    private List<Member> getMemberList(PreparedStatement ps) throws SQLException {
        ResultSet rs = ps.executeQuery();
        List<Member> ls = new ArrayList();

        while (rs.next()) {
            Member member = new Member();
            member.setId(rs.getInt("member_id"));
            member.setName(rs.getString("member_name"));
            member.setEmail(rs.getString("member_mail"));
            member.setBirthdate(rs.getString("member_birthdate"));
            member.setClasse(classDao.getClass(rs.getInt("class_id")));

            ls.add(member);
        }
        return ls;
    }

    @Override
    public void updateMember(Member member) throws SQLException {

        String query= "update member set member_name=?, member_mail=?, member_birthdate=?, class_id=? where member_id = ?";
        PreparedStatement ps= con.prepareStatement(query);
        ps.setString(1, member.getName());
        ps.setString(2, member.getEmail());
        ps.setString(3, member.getBirthdate());
        ps.setInt(4, member.getClasse().getId());
        ps.setInt(5, member.getId());
        ps.executeUpdate();
    }




//    @Override
//    public List<Member> getAllMembers() {
//        return members;
//    }
//
//    @Override
//    public Member getMember(int id) {
//        return members.get(id);
//    }
//
//    @Override
//    public Member getMember(String name) {
//        for(Member aMember : members){
//            if (aMember.getName().equals(name)){
//                return aMember;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public void addMember(Member member) {
//        boolean flag = false;
//        for(Member aMember : members) {
//            if (aMember.getEmail().equals(member.getEmail())) {
//                System.out.println("Error : Member " + aMember.getName() + " email already exists in the database");
//                flag = true;
//            }
//        }
//        if (!flag){
//            members.add(member);
//        }
//    }
//
//    @Override
//    public void updateMember(Member member, String name, String email, String birthdate, Class classe) {
//        boolean flag = false;
//        for(Member aMember : members) {
//            if (aMember.getEmail().equals(email) && aMember.getId() != member.getId()) {
//                System.out.println("Error : Member " + name + " email already exists in the database");
//                flag = true;
//            }
//        }
//        if (!flag){
//            members.get(member.getId()).setName(name);
//            members.get(member.getId()).setEmail(email);
//            members.get(member.getId()).setBirthdate(birthdate);
//            members.get(member.getId()).setClasse(classe);
//            System.out.println("Member: Id " + member.getId() + ", updated in the database");
//        }
//    }
//
//    @Override
//    public void deleteMember(Member member) {
//        boolean flag = false;
//        for(Member aMember : members) {
//            if (aMember.getId() == member.getId() && aMember.getName().equals(member.getName()) && aMember.getEmail().equals(member.getEmail())) {
//                members.remove(aMember.getId());
//                System.out.println("Member: Id " + aMember.getId() + ", deleted from database");
//                flag = true;
//            }
//        }
//        if (!flag){
//            System.out.println("Member: " + member.getName() + ", not found in the database");
//        }
//    }
}