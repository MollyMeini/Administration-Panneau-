package dao;

import models.Class;
import models.Member;

import java.sql.SQLException;
import java.util.List;

public interface ClassDao {
    void addClass(Class classe) throws SQLException;
    void deleteClass(int id) throws SQLException;
    Class getClass(String name) throws SQLException;
    Class getClass(int id) throws SQLException;
    List<Class> getAllClasses() throws SQLException;
    void updateClass(Class classe) throws SQLException;
}