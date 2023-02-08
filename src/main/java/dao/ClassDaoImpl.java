package dao;

import models.Class;
import models.CodeReview;

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
    public Class getClass(String name) {
        for(Class aClass : classes){
            if (aClass.getName().equals(name)){
                return aClass;
            }
        }
        return null;
    }

    @Override
    public void addClass(Class classe) {
        boolean flag = false;
        for(Class aClass : classes) {
            if (aClass.getName().equals(classe.getName())) {
                System.out.println("Class: " + aClass.getName() + ", already exists in the database");
                flag = true;
            }
        }
        if (!flag){
            classes.add(classe);
        }
    }

    @Override
    public void updateClass(Class classe, String className) {
        boolean flag = false;
        for(Class aClass : classes) {
            if (aClass.getName().equals(className)) {
                System.out.println("Class: " + className + ", already exists in the database");
                flag = true;
            }
        }
        if (!flag){
            classes.get(classe.getId()).setName(className);
            System.out.println("Classe: Id " + classe.getId() + ", updated in the database");
        }
    }

    @Override
    public void deleteMember(Class classe) {
        boolean flag = false;
        for(Class aClass : classes) {
            if (aClass.getName().equals(classe.getName())) {
                classes.remove(aClass.getId());
                System.out.println("Classe: Id " + aClass.getId() + ", deleted from database");
                flag = true;
            }
        }
        if (!flag){
            System.out.println("Classe: Id " + classe.getId() + ", not found in the database");
        }
    }
}