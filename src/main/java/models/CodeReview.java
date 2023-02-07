package models;

import javax.persistence.*;
import java.sql.Date;
@Entity
@Table(name="CODEREVIEW")
public class CodeReview {

    //Attributs
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String name;
    private String description;
    private String datetime;
    @ManyToOne
    @JoinColumn(name="classid", nullable=false)
    private Class classe;

    //Constructors
    public CodeReview() {
    }
    public CodeReview(String name, String description, String datetime, Class classe) {
        this.name = name;
        this.description = description;
        this.datetime = datetime;
        this.classe = classe;
    }

    //Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getDatetime() { return datetime; }
    public Class getClasse() { return classe; }

    //Setters
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setDatetime(String datetime) { this.datetime = datetime; }
    public void setClasse(Class classe) { this.classe = classe; }
}