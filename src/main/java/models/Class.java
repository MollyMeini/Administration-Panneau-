package models;


import java.util.ArrayList;
import java.util.List;

public class Class {

    //Attributs
    private int class_id;
    private String class_name;

    private int class_nmembres;

//    private List<Member> memberList;
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

    public List<Member> getMemberList(){//TODO
        return null;
    }
    //Setters
    public void setName(String name) { this.class_name = name; }

    public void setmembres(int nbMemebres) { this.class_nmembres = nbMemebres; }
    public void setId(int id) { this.class_id = id; }

//    public void setMemberList(List<Member> memberList){this.memberList=memberList;}


    @Override
    public String toString()
    {
        return "Class [class_id=" + class_id + ", class_name=" + class_name  + "]";
    }

}