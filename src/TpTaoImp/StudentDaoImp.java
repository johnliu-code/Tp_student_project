/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TpTaoImp;

import InterfaceDao.StudentDao;
import Model.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jeanl
 */
public class StudentDaoImp implements StudentDao {

    private final List<Student> listStudents;
    Scanner sc = new Scanner(System.in);

    public StudentDaoImp() {
        listStudents = new ArrayList<>();
    }

    @Override
    public List<Student> findAll() {
        return listStudents;
    }

    @Override
    public void create(Student student) {

        System.out.println("How many students you want to create? ");
        int numOfCreate = sc.nextInt();

        int studentNum = 0;
        while (studentNum < numOfCreate) {
            System.out.println("Student ID number: ");
            int id = sc.nextInt();
            System.out.println("Student First Name: ");
            String firstname = sc.next();
            System.out.println("Student Last Name: ");
            String lastname = sc.next();
            System.out.println("Student Gender: M/F?");
            String gender = sc.next();

            student = new Student(id, firstname, lastname, gender);
            listStudents.add(student);
            studentNum++;
        }
    }

    @Override
    public void delete(Student student) {
        System.out.println("Delete student by id, please entre Id number: ");
        int byId = sc.nextInt();
        for (Student s : listStudents) {
            if (s.getId() == byId) {
                listStudents.remove(s);
                break;
            }
        }
    }

    @Override
    public void update(Student student) {
        System.out.println("Update student by id, please entre Id number: ");
        int updateId = sc.nextInt();

        for (Student s : listStudents) {
            System.out.println("Id of" + updateId + "   " +  "First Name: " + s.getFirstName() + "   "+ "Last Name: " + s.getLastName() + "   "+ "Gender: " + s.getGender());
            if (s.getId() == updateId) {
                System.out.println("Update the 1: Id; 2: First Name; 3: Last Name; 4: Gender, your choice number is?");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Please entre new Id number:");
                        int newId = sc.nextInt();
                        s.setId(newId);
                        break;
                    case 2:
                        System.out.println("Please entre new First Name: ");
                        String newFirstName = sc.next();
                        s.setFirstName(newFirstName);
                        break;
                    case 3:
                        System.out.println("Please entre new Last Name: ");
                        String newLastName = sc.next();
                        s.setLastName(newLastName);
                        break;
                    case 4:
                        System.out.println("Please entre new Gender: ");
                        String newGender = sc.next();
                        s.setGender(newGender);
                        break;
                    default:
                        System.out.println("Please entre number 1 to 4");
                }
            }
        }
    }

    @Override
    public void display(Student student) {
        System.out.println("Students list");
        System.out.println("Id : " + "         " + "First Name : " + "         " + " Last Name : " + "         " + "Gender: ");
        listStudents.forEach((s) -> {
            System.out.println(s.getId() + "               "
                    + s.getFirstName() + "               "
                    + s.getLastName() + "               "
                    + s.getGender());
        });
        System.out.println("------------------------------------------");
    }

    @Override
    public void find(Student student) {
        System.out.println("Find Sudent by 1: Id; 2: First Name; 3 Last Name, please entre your choice number: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Sudent Id number: ");
                int id = sc.nextInt();
                listStudents.forEach((s) -> {
                    if (s.getId() == id) {
                        System.out.println("Id of: " + id + "     "
                                + "First Name: " + s.getFirstName() + "     "
                                + "Last Name:  " + s.getLastName() + "    "
                                + "Gender: " + s.getGender());

                    }
                });
                break;
            case 2:
                System.out.println("Sudent First Name: ");
                String firstname = sc.next();
                listStudents.forEach((s) -> {
                    if (s.getFirstName().equals(firstname)) {
                        System.out.println("Id " + s.getId() + "   "
                                + "First Name of: " + firstname + "   "
                                + "Last Name: " + s.getLastName() + "   "
                                + "Gender: " + s.getGender());
                    }
                });
                break;
            case 3:
                System.out.println("Sudent Last Name: ");
                String lastname = sc.next();
                listStudents.forEach((s) -> {
                    if (s.getLastName().equals(lastname)) {
                        System.out.println("Id: " + s.getId() + "   "
                                + "First Name: " + s.getFirstName() + "   "
                                + "Last Name of: " + s.getLastName() + "   "
                                + "Gender: " + s.getGender());
                    }
                });
                break;
            default:
                System.out.println("Please entre number 1 to 3");

        }
    }
}
