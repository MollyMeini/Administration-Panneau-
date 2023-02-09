package dao;

import models.Class;
import models.Member;
import utils.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassDaoImpl implements ClassDao {

    static Connection con = DbConnection.getConnection();

    @Override
    public void addClass(Class classe) throws SQLException {
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
}