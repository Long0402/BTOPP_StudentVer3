package studentver3;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Processor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PersonList personList = new PersonList();
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Add a new student");
            System.out.println("2. Add a new teacher");
            System.out.println("3. Update person");
            System.out.println("4. Delete person by id");
            System.out.println("5. Find person by id");
            System.out.println("6. Display all students and teachers");
            System.out.println("7. Find the student with the highest GPA");
            System.out.println("8. Find a teacher by department");
            System.out.println("9. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();
            System.out.println("**************");
            switch (choice) {
                case 1:
                    System.out.print("Enter ID Student: ");
                    String idst = sc.nextLine();
                    System.out.print("Enter Full Name Student: ");
                    String fullName = sc.nextLine();
                    System.out.print("Enter Date Of Birth: ");
                    String dateOfBirth = sc.nextLine();
                    Date date = null;
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        date = sdf.parse(dateOfBirth);
                    } catch (Exception e) {
                        System.out.println("Wrong format!");
                    }
                    System.out.print("Enter GPA: ");
                    float gpa = sc.nextFloat();
                    sc.nextLine();
                    System.out.print("Enter Major: ");
                    String major = sc.nextLine();
                    personList.addStudent(new Student(gpa, major, idst, fullName, date));
                    System.out.println("*************");
                    break;
                case 2:
                    System.out.print("Enter ID Teacher: ");
                    String idtc = sc.nextLine();
                    System.out.print("Enter Full Name Teacher: ");
                    String fullNamet = sc.nextLine();
                    System.out.print("Enter Date Of Birth: ");
                    String dateOfBirthTeacher = sc.nextLine();
                    Date dateTeacher = null;
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        dateTeacher = sdf.parse(dateOfBirthTeacher);
                    } catch (Exception e) {
                        System.out.println("Wrong format!");
                    }
                    System.out.print("Enter Department: ");
                    String department = sc.nextLine();
                    System.out.print("Enter Teaching Subject: ");
                    String teachingSubject = sc.nextLine();
                    personList.addTeacher(new Teacher(department, teachingSubject, idtc, fullNamet, dateTeacher));
                    System.out.println("******************");
                    break;
                case 3:

                    System.out.print("Enter ID To Update: ");
                    String idUpDate = sc.nextLine();
                    System.out.print("Enter New Full Name Student: ");
                    String FullNameupDate = sc.nextLine();
                    Person updatePerson = personList.findPersonByID(idUpDate);

                    if (updatePerson != null) {
                        if (updatePerson instanceof Student) {
                            System.out.print("Enter New Full Name Student: ");
                            String newFullNameS = sc.nextLine();
                            updatePerson.setFullName(newFullNameS);
                            System.out.print("Enter New Date Of Birth: ");
                            String newDateOfBirth = sc.nextLine();

                            try {
                                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                Date newDate = sdf.parse(newDateOfBirth);
                                updatePerson.setDateOfBirth(newDate);
                            } catch (Exception e) {
                                System.out.println("Wrong format!");
                            }
                            System.out.print("Enter New GPA: ");
                            float newGPA = sc.nextFloat();
                            sc.nextLine();
                            ((Student) updatePerson).setGpa(newGPA);
                            System.out.print("Enter New Major: ");
                            String newMajor = sc.nextLine();
                            ((Student) updatePerson).setMajor(newMajor);

                        } else if (updatePerson instanceof Teacher) {
                            System.out.print("Enter New Full Name Teacher: ");
                            String newFullNameT = sc.nextLine();
                            updatePerson.setFullName(newFullNameT);
                            System.out.print("Enter New Date Of Birth: ");
                            String newDateOfBirthT = sc.nextLine();
                            try {
                                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                Date newDateT = sdf.parse(newDateOfBirthT);
                                updatePerson.setDateOfBirth(newDateT);
                            } catch (Exception e) {
                                System.out.println("Wrong format!");

                            }
                            System.out.print("Enter New Department: ");
                            String newDepartment = sc.nextLine();
                            ((Teacher) updatePerson).setDepartment(newDepartment);
                            System.out.print("Enter New Teaching Subject: ");
                            String newTeachingSubject = sc.nextLine();
                            ((Teacher) updatePerson).setTeachingSubject(newTeachingSubject);

                        }
                        System.out.println("Person Updated!");
                        System.out.println("*************");
                    } else {
                        System.out.println("Person not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter ID To Delete: ");
                    String deleteID = sc.nextLine();
                    personList.deletePersonById(deleteID);
                    System.out.println("******************");
                    break;
                case 5:
                    System.out.print("Enter ID To Find: ");
                    String findID = sc.nextLine();
                    Person foundPerson = personList.findPersonByID(findID);
                    if (foundPerson != null) {
                        System.out.println("Person found: " + foundPerson);
                        foundPerson.displayInfo();;
                    } else {
                        System.out.println("Person not found!");
                    }
                    System.out.println("*************");
                    break;
                case 6:
                    System.out.println("Display All Students and Teacher: ");
                    personList.displayEveryone();
                    System.out.println("*************");
                    break;
                case 7:
                    System.out.println("Find The Student With The Highest GPA: ");
                    Student topStudent = personList.findTopStudent();
                    if (topStudent != null) {
                        topStudent.displayInfo();
                    } else {
                        System.out.println("No students found.");
                    }
                    System.out.println("**************");
                    break;
                case 8:
                    System.out.print("Find The Teacher By Department: ");
                    String findDepartment = sc.nextLine();
                    Teacher teacher = personList.findTeacherByDepartment(findDepartment);
                    if (teacher != null) {
                        teacher.displayInfo();
                    } else {
                        System.out.println("No teacher Found In That Department!");
                    }
                    System.out.println("*************");
                    break;
                case 9:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");

            }

        }
    }
}
