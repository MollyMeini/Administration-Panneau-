package dao;

import models.Class;
import models.CodeReview;
import models.Member;
import utils.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CodeReviewDaoImpl implements CodeReviewDao {

    static Connection con = DbConnection.getConnection();

    private ClassDao classDao=new ClassDaoImpl();

    @Override
    public void addCodeReview(CodeReview codeReview) throws SQLException {
        String query = "insert into codereview (cr_name, cr_description, member_birthdate, class_id) VALUES (?,?,?,?)";
        PreparedStatement ps  = con.prepareStatement(query);
        ps.setString(1, codeReview.getName());
        ps.setString(2, codeReview.getDescription());
        ps.setString(3, codeReview.getDatetime());
        ps.setInt(4, codeReview.getClasse().getId());
        ps.executeUpdate();
    }

    @Override
    public void deleteCodeReview(int id) throws SQLException {
        String query= "delete from codereview where cr_id =?";
        PreparedStatement ps= con.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public CodeReview getCodeReview(int id) throws SQLException {
        String query= "select * from codereview where cr_id= ?";
        PreparedStatement ps= con.prepareStatement(query);
        ps.setInt(1, id);
        return getaCodeReview(ps);
    }

    private CodeReview getaCodeReview(PreparedStatement ps) throws SQLException {
        CodeReview codeReview = new CodeReview();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            codeReview.setId(rs.getInt("cr_id"));
            codeReview.setName(rs.getString("cr_name"));
            codeReview.setDescription(rs.getString("cr_description"));
            codeReview.setDatetime(rs.getString("cr_datetime"));
            codeReview.setClasse(classDao.getClass(rs.getInt("class_id")));
        }

        if (check == true) {
            return codeReview;
        }
        else
            return null;
    }

    @Override
    public List<CodeReview> getAllCodeReview() throws SQLException {
        String query = "select * from codereview";
        PreparedStatement ps= con.prepareStatement(query);
        return getCodeReviewList(ps);
    }

    private List<CodeReview> getCodeReviewList(PreparedStatement ps) throws SQLException {
        ResultSet rs = ps.executeQuery();
        List<CodeReview> ls = new ArrayList();

        while (rs.next()) {
            CodeReview cr = new CodeReview();
            cr.setId(rs.getInt("cr_id"));
            cr.setName(rs.getString("cr_name"));
            cr.setDescription(rs.getString("cr_description"));
            cr.setDatetime(rs.getString("cr_datetime"));
            cr.setClasse(classDao.getClass(rs.getInt("class_id")));

            ls.add(cr);
        }
        return ls;
    }

    @Override
    public void updateCodeReview(CodeReview codeReview) throws SQLException {
        String query= "update codeReview set cr_name=?, cr_description=?, cr_datetime=?, class_id=? where cr_id = ?";
        PreparedStatement ps= con.prepareStatement(query);
        ps.setString(1, codeReview.getName());
        ps.setString(2, codeReview.getDescription());
        ps.setString(3, codeReview.getDatetime());
        ps.setInt(4, codeReview.getClasse().getId());
        ps.setInt(5, codeReview.getId());
        ps.executeUpdate();
    }
}