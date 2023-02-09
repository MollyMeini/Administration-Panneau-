package models;

import javax.persistence.*;
import java.sql.Date;

public class CodeReview {

    //Attributs
    private int id;
    private String name;
    private String description;
    private String datetime;
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
    public void setId(int id) { this.id = id; }
}