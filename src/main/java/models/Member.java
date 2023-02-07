package models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="MEMBER")
public class Member {

    //Attributs
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String name;
    private String email;
    private String birthdate;
    @ManyToOne
    @JoinColumn(name="classid", nullable=false)
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
}