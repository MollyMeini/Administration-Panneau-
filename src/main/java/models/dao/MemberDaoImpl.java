import java.util.ArrayList;
import java.util.List;

public class MemberDaoImpl implements MemberDao {

    //list is working as a database
    List<Member> members;

    public MemberDaoImpl(){
        members = new ArrayList<Member>();
        Member member1 = new Member("Robert","test","12/05/2015",);
        Member member2 = new Member("John","test2","12/05/2015",);
        students.add(student1);
        students.add(student2);
    }
    @Override
    public void deleteStudent(Student student) {
        students.remove(student.getRollNo());
        System.out.println("Student: Roll No " + student.getRollNo() + ", deleted from database");
    }

    //retrive list of students from the database
    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    @Override
    public Student getStudent(int rollNo) {
        return students.get(rollNo);
    }

    @Override
    public void updateStudent(Student student) {
        students.get(student.getRollNo()).setName(student.getName());
        System.out.println("Student: Roll No " + student.getRollNo() + ", updated in the database");
    }
}