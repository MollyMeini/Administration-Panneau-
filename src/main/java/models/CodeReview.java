@Entity
@Table(name="CODEREVIEW")
public class CodeReview {

    //Attributs
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String name;
    private String description;
    private Date datetime;
    private Class classmember;

    //Constructors
    public CodeReview() {
    }
    public CodeReview(String name, String description, Date datetime, Class classmember) {
        this.name = name;
        this.description = description;
        this.datetime = datetime;
        this.classmember = classmember;
    }

    //Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public Date getDatetime() { return datetime; }
    public Class getClassmember() { return classmember; }

    //Setters
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setDatetime(Date datetime) { this.datetime = datetime; }
    public void setClassmember(Class classmember) { this.classmember = classmember; }
}