import java.util.List;

public interface ClassDao {
    public List<Class> getAllClasses();
    public Member getClass(int id);
    public void updateClass(Class classe);
    public void deleteMember(Class classe);
}