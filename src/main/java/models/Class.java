package models;


import dao.MemberDao;
import dao.MemberDaoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Class {

    //Attributs
    private int class_id;
    private String class_name;
    private int class_nmembres;
    private MemberDao memberDao = new MemberDaoImpl();

    //Constructors
    public Class() {
    }
    public Class(String class_name, int class_nmembres) {
        this.class_name = class_name;
        this.class_nmembres = class_nmembres;
    }

    //Getters
    public int getId() { return class_id; }
    public String getName() { return class_name; }
    public int getNmembres() { return class_nmembres; }

    //Setters
    public void setName(String name) { this.class_name = name; }
    public void setNmembres(int nbMemebres) { this.class_nmembres = nbMemebres; }
    public void setId(int id) { this.class_id = id; }

    @Override
    public String toString()
    {
        return "Class [class_id=" + class_id + ", class_name=" + class_name  + "]";
    }

    public List<Member> getMembers(Class classe) throws SQLException {
        return memberDao.getAllMembersByClass(classe.getId());
    }

}