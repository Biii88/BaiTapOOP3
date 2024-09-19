package baitapoop_student_ver3;

import java.util.ArrayList;
import java.util.Date;

public class PersonList {
    private ArrayList<Person> personList;

    public PersonList(ArrayList<Person> personList) {
        this.personList = personList;
    }
    
    public PersonList() {
        this.personList = new ArrayList<>();
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(ArrayList<Person> personList) {
        this.personList = personList;
    }
    
    public void addStudent(Student student) {
        personList.add(student);
    }
    
    public void addTeacher(Teacher teacher) {
        personList.add(teacher);
    }
    
    public void updatePerson(String id, String newName, Date newDateOfBirth) {
        Person person = findPersonById(id);
        if (person != null) {
            person.setFullName(newName);
            person.setDateOfBirth(newDateOfBirth);
            System.out.println("Person updated successfully.");
        } else {
            System.out.println("Person not found.");
        }
    }
    
    public void deletePersonById(String id) {
        personList.removeIf(person -> person.getId().equals(id));
    }
    
    public Person findPersonById(String id) {
        for (Person person : personList) {
            if (person.getId().equals(id)) {
                return person;
            }
        }
        return null;
    }
    
    public void displayEveryone() {
        for (Person person : personList) {
            person.displayInfo();
            System.out.println();
        }
    }
    
    public Student findTopStudent() {
        Student topStudent = null;
        for (Person person : personList) {
            if (person instanceof Student) {
                if (topStudent == null || ((Student) person).getGpa() > topStudent.getGpa()) {
                    topStudent = (Student) person;
                }
            }
        }
        return topStudent;
    }
    
    public ArrayList<Teacher> findTeachersByDepartment(String department) {
        ArrayList<Teacher> teachers = new ArrayList<>();
        for (Person person : personList) {
            if (person instanceof Teacher && ((Teacher) person).getDepartment().equalsIgnoreCase(department)) {
                teachers.add((Teacher) person);
            }
        }
        return teachers;
    }
}