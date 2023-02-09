package dao;

import models.Class;

import java.sql.SQLException;
import java.util.List;

public interface ClassDao {
    void addClass(Class classe) throws SQLException;

    void deleteClass(int id) throws SQLException;

    Class getClass(String name) throws SQLException;

    Class getClass(int id) throws SQLException;

    List<Class> getAllClasses() throws SQLException;

    void updateClass(Class classe) throws SQLException;
//    public List<Class> getAllClasses() throws SQLException;
//    public Class getClass(int id);
//
//    void deleteClass(int id) throws SQLException;
//
//    public Class getClass(String name) throws SQLException;
//    public void addClass(Class classe) throws SQLException;
//    public void updateClass(Class classe) throws SQLException;
////    public void deleteMember(Class classe);



}