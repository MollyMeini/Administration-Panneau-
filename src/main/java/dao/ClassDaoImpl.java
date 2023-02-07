package dao;

import models.Class;

import java.util.ArrayList;
import java.util.List;

public class ClassDaoImpl implements ClassDao {

    //list is working as a database
    List<Class> classes;

    public ClassDaoImpl(){
        classes = new ArrayList<Class>();
        Class class1 = new Class("Robert");
        Class class2 = new Class("John");
        classes.add(class1);
        classes.add(class2);
    }

    public void deleteCodeReview(Class classe) {
        classes.remove(classe.getId());
        System.out.println("Classe: Id " + classe.getId() + ", deleted from database");
    }

    @Override
    public List<Class> getAllClasses() {
        return classes;
    }

    @Override
    public Class getClass(int id) {
        return classes.get(id);
    }

    @Override
    public void updateClass(Class classe) {
        classes.get(classe.getId()).setName(classe.getName());
        System.out.println("Classe: Id " + classe.getId() + ", updated in the database");
    }

    @Override
    public void deleteMember(Class classe) {
        classes.remove(classe.getId());
        System.out.println("Classe: Id " + classe.getId() + ", deleted from database");
    }

}