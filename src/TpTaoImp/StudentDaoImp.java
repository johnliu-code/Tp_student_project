/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TpTaoImp;

import InterfaceDao.StudentDao;
import Model.Results;
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
        int numOfCreate = validateInputaNum();

        int studentNum = 0;
        while (studentNum < numOfCreate) {
            System.out.println("Student ID number: ");
            int id = validateInputaNum();
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
    public void delete(Student student, List<Results> listResults) {
        System.out.println("Delete student by id, please entre Id number: ");
        int byId = validateInputaNum();

        List<Student> studentsToRemove = new ArrayList<>();
        listStudents.forEach((Student s) -> {
            int deleteId = s.getId();
            if (deleteId == byId) {
                System.out.println("Id = " + deleteId+ ", Would you want to delete the Student with this Id? " + " Y/N ?");
                String choice = sc.next().toUpperCase();
                if("Y".equals(choice)) {
                    studentsToRemove.add(s);

                    //CHeck to delete results with this student
                    if (!listResults.isEmpty()) {
                        System.out.println("Are you sure want to delete Student all of the Results? Y/N");
                        String opt = sc.next().toUpperCase();
                        if("Y".equals(opt)) {
                            List<Results> resultsToRemove = new ArrayList<>();
                            listResults.forEach((Results r) -> {
                                int studentId = r.getStudent().getId();
                                if (studentId == byId) {
                                    resultsToRemove.add(r);
                                }
                            });
                            listResults.removeAll(resultsToRemove);
                        }
                    }
                }
            }
        });

        listStudents.removeAll(studentsToRemove);
    }

    @Override
    public void update(Student student) {
        System.out.println("Update student by id, please entre Id number: ");
        int updateId = validateInputaNum();
        for (Student findStu : listStudents) {
            if (findStu.getId() == updateId) {
                student =findStu;
            }
        }
        System.out.println("Id of: " + student.getId() + "   "
                +  "First Name: " + student.getFirstName() + "   "
                + "Last Name: " + student.getLastName() + "   "
                + "Gender: " + student.getGender());

        System.out.println("Update the 1: Id; 2: First Name; 3: Last Name; 4: Gender, your choice number is?");
                int choice = validateInputaNum();
                switch (choice) {
                    case 1 -> {
                        System.out.println("Please entre new Id number:");
                        int newId = validateInputaNum();
                        student.setId(newId);
                    }
                    case 2 -> {
                        System.out.println("Please entre new First Name: ");
                        String newFirstName = sc.next();
                        student.setFirstName(newFirstName);
                    }
                    case 3 -> {
                        System.out.println("Please entre new Last Name: ");
                        String newLastName = sc.next();
                        student.setLastName(newLastName);
                    }
                    case 4 -> {
                        System.out.println("Please entre new Gender: ");
                        String newGender = sc.next();
                        student.setGender(newGender);
                    }
                    default -> System.out.println("Please entre number 1 to 4");
                }
    }



    @Override
    public void display(Student student) {
        System.out.println("Students list");
        System.out.println("Id : " + "         " + "First Name : " + "         " + " Last Name : " + "         " + "Gender: ");
        listStudents.forEach((s) -> System.out.println(s.getId() + "               "
                + s.getFirstName() + "               "
                + s.getLastName() + "               "
                + s.getGender()));
        System.out.println("------------------------------------------");
    }

    @Override
    public void find(Student student) {
        System.out.println("Find Sudent by 1: Id; 2: First Name; 3 Last Name, please entre your choice number: ");
        int choice = validateInputaNum();
        switch (choice) {
            case 1 -> {
                System.out.println("Sudent Id number: ");
                int id = validateInputaNum();
                listStudents.forEach((s) -> {
                    if (s.getId() == id) {
                        System.out.println("Id of: " + id + "     "
                                + "First Name: " + s.getFirstName() + "     "
                                + "Last Name:  " + s.getLastName() + "    "
                                + "Gender: " + s.getGender());

                    }
                });
            }
            case 2 -> {
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
            }
            case 3 -> {
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
            }
            default -> System.out.println("Please entre number 1 to 3");
        }
    }

    //Validation method
    public int validateInputaNum() {
        Scanner sc = new Scanner(System.in);
        int inputNum;
        try {
            inputNum = sc.nextInt();
        } catch (Exception e) {
            System.out.println("This is not a number, please try again. ");
            return validateInputaNum ();
        }
        return inputNum;
    }
}
