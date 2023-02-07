package dao;

import models.Class;

import java.util.List;

public interface ClassDao {
    public List<Class> getAllClasses();
    public Class getClass(int id);
    public void updateClass(Class classe);
    public void deleteMember(Class classe);
}