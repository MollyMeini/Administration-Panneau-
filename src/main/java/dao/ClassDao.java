package dao;

import models.Class;

import java.util.List;

public interface ClassDao {
    public List<Class> getAllClasses();
    public Class getClass(int id);
    public Class getClass(String name);
    public void addClass(Class classe);
    public void updateClass(Class classe, String className, int nMembers);
    public void deleteClass(Class classe);
}