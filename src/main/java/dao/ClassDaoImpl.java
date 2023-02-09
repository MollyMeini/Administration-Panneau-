package dao;

import models.Class;
import utils.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassDaoImpl implements ClassDao {


    static Connection con = DbConnection.getConnection();

    private MemberDao memberDao = new MemberDaoImpl();

    @Override
    public void addClass(Class classe) throws SQLException {
//        System.out.println("aaaaaaaa");
        System.out.println(classe.getName());
        String query = "insert into class (class_name, class_nmembres) VALUES (?,?)";
        PreparedStatement ps  = con.prepareStatement(query);
        ps.setString(1, classe.getName());
        ps.setInt(2, classe.getNmembres());
        ps.executeUpdate();
    }

    @Override
    public void deleteClass(int id) throws SQLException
    {
        String query= "delete from class where class_id =?";
        PreparedStatement ps= con.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public Class getClass(String name) throws SQLException {
        String query= "select * from class where class_name= ?";
        PreparedStatement ps= con.prepareStatement(query);
        ps.setString(1, name);
        return getaClass(ps);
    }

    @Override
    public Class getClass(int id) throws SQLException {
        String query= "select * from class where class_id= ?";
        PreparedStatement ps= con.prepareStatement(query);
        ps.setInt(1, id);
        return getaClass(ps);
    }

    private Class getaClass(PreparedStatement ps) throws SQLException {
        Class classe = new Class();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            classe.setId(rs.getInt("class_id"));
            classe.setName(rs.getString("class_name"));
//            classe.setMemberList(memberDao.getAllMembersByClass(rs.getInt("class_id")));
        }

        if (check == true) {
            return classe;
        }
        else
            return null;
    }

    @Override
    public List<Class> getAllClasses() throws SQLException {
        String query = "select * from class";
        PreparedStatement ps= con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Class> ls = new ArrayList();

        while (rs.next()) {
            Class classe = new Class();
            classe.setId(rs.getInt("class_id"));
            classe.setName(rs.getString("class_name"));
//            classe.setMemberList(memberDao.getAllMembersByClass(rs.getInt("class_id")));
            ls.add(classe);
        }
        return ls;
    }

    @Override
    public void updateClass(Class classe) throws SQLException {

        String query= "update class set class_name=? where class_id = ?";
        PreparedStatement ps= con.prepareStatement(query);
        ps.setString(1, classe.getName());
        ps.setInt(2, classe.getId());
        ps.executeUpdate();
    }

    //list is working as a database
//    List<Class> classes;
//
//    public ClassDaoImpl(){
//        classes = new ArrayList<Class>();
//        Class class1 = new Class("Robert", classId);
//        Class class2 = new Class("John", classId);
//        classes.add(class1);
//        classes.add(class2);
//    }
//
//    public void deleteCodeReview(Class classe) {
//        classes.remove(classe.getId());
//        System.out.println("Classe: Id " + classe.getId() + ", deleted from database");
//    }
//
//    @Override
//    public List<Class> getAllClasses() {
//        return classes;
//    }
//
//    @Override
//    public Class getClass(int id) {
//        return classes.get(id);
//    }
//
//    @Override
//    public Class getClass(String name) {
//        for(Class aClass : classes){
//            if (aClass.getName().equals(name)){
//                return aClass;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public void addClass(Class classe) {
//        boolean flag = false;
//        for(Class aClass : classes) {
//            if (aClass.getName().equals(classe.getName())) {
//                System.out.println("Class: " + aClass.getName() + ", already exists in the database");
//                flag = true;
//            }
//        }
//        if (!flag){
//            classes.add(classe);
//        }
//    }

//    @Override
//    public void updateClass(Class classe, String className) {
//        boolean flag = false;
//        for(Class aClass : classes) {
//            if (aClass.getName().equals(className)) {
//                System.out.println("Class: " + className + ", already exists in the database");
//                flag = true;
//            }
//        }
//        if (!flag){
//            classes.get(classe.getId()).setName(className);
//            System.out.println("Classe: Id " + classe.getId() + ", updated in the database");
//        }
//    }
//
//    @Override
//    public void deleteMember(Class classe) {
//        boolean flag = false;
//        for(Class aClass : classes) {
//            if (aClass.getName().equals(classe.getName())) {
//                classes.remove(aClass.getId());
//                System.out.println("Classe: Id " + aClass.getId() + ", deleted from database");
//                flag = true;
//            }
//        }
//        if (!flag){
//            System.out.println("Classe: Id " + classe.getId() + ", not found in the database");
//        }
//    }

}