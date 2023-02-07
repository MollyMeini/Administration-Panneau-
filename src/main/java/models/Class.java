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
    @OneToMany(mappedBy="class")
    private Set<Member> members;

    //Constructors
    public Class() {
    }
    public Class(String name) {
        this.name = name;
    }

    //Getters
    public int getId() { return id; }
    public String getName() { return name; }

    //Setters
    public void setName(String name) { this.name = name; }
}