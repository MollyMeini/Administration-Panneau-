package models;

import javax.persistence.*;
import java.sql.Date;


public class Member {

    //Attributs
    private int id;
    private String name;
    private String email;
    private String birthdate;
    private Class classe;


    //Constructors
    public Member() {
    }
    public Member(String name, String email, String birthdate, Class classe) {
        this.name = name;
        this.email = email;
        this.birthdate = birthdate;
        this.classe = classe;
    }

    //Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getBirthdate() { return birthdate; }
    public Class getClasse() { return classe; }

    //Setters
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setBirthdate(String birthdate) { this.birthdate = birthdate; }
    public void setClasse(Class classe) { this.classe = classe; }

    public void setId(int id) { this.id= id; }
}