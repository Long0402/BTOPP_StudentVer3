package studentver3;

import java.util.ArrayList;

public class PersonList {

    public ArrayList<Person> personList;

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

    public void updatePerson(String id, Person updatePerson) {
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getId().equals(id)) {
                personList.set(i, updatePerson);
            }
            break;
        }
    }

    public void deletePersonById(String id) {
        personList.removeIf(Person -> Person.getId().equals(id));
    }

    public Person findPersonByID(String id) {
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
        }
    }

    public Student findTopStudent() {
        Student topStudent = null;
        for (Person person : personList) {
            if (person instanceof Student) {
                Student student = (Student) person;
                if (topStudent == null || student.getGpa() > topStudent.getGpa()) {
                    topStudent = student;
                }
            }

        }
        return topStudent;
    }

    public Teacher findTeacherByDepartment(String departmentt) {
        for (Person person : personList) {
            if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                if (teacher.getDepartment().equals(departmentt)) {
                    return teacher;
                }
            }
        }
        return null;
    }
}
