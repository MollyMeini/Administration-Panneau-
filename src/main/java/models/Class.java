package models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="CLASS")
public class Class {

    //Attributs
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String name;
    private int nMembers;

    //Constructors
    public Class() {
    }
    public Class(String name, int nMembers) {

        this.name = name;
        this.nMembers = nMembers;
    }

    //Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getnMembers() { return nMembers; }

    //Setters
    public void setName(String name) { this.name = name; }
    public void setnMembers(int nMembers) { this.nMembers = nMembers; }
}