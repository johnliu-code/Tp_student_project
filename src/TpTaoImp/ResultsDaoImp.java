/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TpTaoImp;

import InterfaceDao.ResultsDao;
import Model.Course;
import Model.Results;
import Model.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jeanl
 */
public class ResultsDaoImp implements ResultsDao {

    Scanner sc = new Scanner(System.in);
    private final List<Results> listResults;

    Results results = new Results();
    Student student = new Student();
    Course course = new Course();

    public ResultsDaoImp() {
        listResults = new ArrayList<>();
    }

    @Override
    public List<Results> findAll() {
        return listResults;
    }

    @Override
    public void create(List<Student> listStudents, List<Course> listCourses, double mark1, double mark2) {
        String answer = "Y";

        while ("Y".equals(answer)) {
            System.out.println("Please entre a Student Id to add results: ");
            int stuId = validateInputNum();
            for (Student s : listStudents) {
                if (s.getId() == stuId) {
                    System.out.println("Sudent Id of " + s.getId() + "  Student is: " + s.getFirstName() + "   " + s.getLastName());
                    student = s;
                    String ans = "Y";
                    while ("Y".equals(ans)) {
                        System.out.println("Please entre a Course Id to add results: ");
                        int courseId = validateInputNum();
                        for (Course c : listCourses) {
                            if (c.getId() == courseId) {
                                course = c;
                                System.out.println("Course Id of " + c.getId() + " " + "is: " + course.getCourseName());
                                System.out.println("Please entre Mark1 for Cours: " + course.getCourseName());
                                mark1 = validateInputDouble();
                                System.out.println("Please entre Mark2 for Cours: " + course.getCourseName());
                                mark2 = validateInputDouble();

                                results = new Results(student, course, mark1, mark2);
                                listResults.add(results);

                                System.out.println("Continue to add Results to another Course? Y/N");
                                ans = sc.next().toUpperCase();
                            }

                        }
                    }
                    System.out.println("Continue to add Results to another Student? Y/N");
                    answer = sc.next().toUpperCase();
                }
            }
        }

    }

    @Override
    public void delete(List<Results> listResults) {
        System.out.println("Delete results from which student? Please entre student Id");
        int deleteStuId = validateInputNum();
        System.out.println("Delete results from which course? Please entre course Id");
        int deleteCourseId = validateInputNum();

        List<Results> resultsToRemove = new ArrayList<>();
        listResults.forEach((Results r) -> {
            int studentId = r.getStudent().getId();
            int courseId = r.getCourse().getId();
            if (studentId == deleteStuId && courseId == deleteCourseId) {
                resultsToRemove.add(r);
                results = r;
            }
        });
        System.out.println("Are you sure want to delete Student: " + results.getStudent().getFirstName() + " "
                + "with Course : " + results.getCourse().getCourseName() + " all of the Results? Y/N");
        String choice = sc.next().toUpperCase();
        if("Y".equals(choice)) {
            listResults.removeAll(resultsToRemove);
        }
    }

    @Override
    public void update(List<Student> listStudents, List<Course> listCourses, double mark1, double mark2) {
        System.out.println("Update results from which student? Please entre student Id");
        int deleteStuId = validateInputNum();
        System.out.println("Update results from which course? Please entre course Id");
        int deleteCourseId = validateInputNum();
        for (Results r : listResults) {
            if (r.getStudent().getId() == deleteStuId && r.getCourse().getId() == deleteCourseId) {
                System.out.println("Which marks you want to update? 1: All; 2: Mark1; 3 Mark2");
                int option = validateInputNum();
                switch (option) {
                    case 1 -> {
                        System.out.println("New mark1 value is: ");
                        double newMark1 = validateInputDouble();
                        r.setMark1(newMark1);
                        System.out.println("New mark2 value is: ");
                        double newMark2 = validateInputDouble();
                        r.setMark2(newMark2);
                    }
                    case 2 -> {
                        System.out.println("New mark1 value is: ");
                        double mark1New = validateInputDouble();
                        r.setMark1(mark1New);
                    }
                    case 3 -> {
                        System.out.println("New mark2 value is: ");
                        double mark2New = validateInputDouble();
                        r.setMark2(mark2New);
                    }
                    default -> System.out.println("Please entre your choice number 1 to 3");
                }
            }
        }
    }

    @Override
    public void display(List<Results> listResults) {
        listResults.forEach((r) -> System.out.println("Student Name: " + r.getStudent().getFirstName() + " " + r.getStudent().getLastName() + "   "
                + "Course Name: " + r.getCourse().getCourseName() + "   "
                + "Mark1: " + r.getMark1() + "   "
                + "Mark2: " + r.getMark2()));
    }

    @Override
    public void find(Results results) {
        System.out.println("Find results by Student 1: Id; 2: First Name and Last Name? please entre your choice number; ");
        int choice = validateInputNum();
        switch (choice) {
            case 1 -> {
                System.out.println("Student Id number: ");
                int stuId = validateInputNum();
                for (Results r : listResults) {
                    if (r.getStudent().getId() == stuId) {
                        System.out.println("Which Course results you are looking for? Please entre course 1: Id or 2: Name. Your choice number: ");
                        int choiceNum = validateInputNum();
                        switch (choiceNum) {
                            case 1 -> {
                                System.out.println("Course Id: ");
                                int findId = validateInputNum();
                                if (r.getCourse().getId() == findId) {
                                    System.out.println("Student: " + r.getStudent().getFirstName() + " " + r.getStudent().getLastName() + "   "
                                            + "Course: " + r.getCourse().getCourseName() + "   "
                                            + "Mark1: " + r.getMark1() + "   "
                                            + "Mark2: " + r.getMark2());
                                } else {
                                    System.out.println("Didn't find Cours results of Id: " + findId + " Please try again later");
                                }
                            }
                            case 2 -> {
                                System.out.println("Course Name: ");
                                String findCourseName = sc.next();
                                if (r.getCourse().getCourseName().equalsIgnoreCase(findCourseName)) {
                                    System.out.println("Student: " + r.getStudent().getFirstName() + " " + r.getStudent().getLastName() + "   "
                                            + "Course: " + r.getCourse().getCourseName() + "   "
                                            + "Mark1: " + r.getMark1() + "   "
                                            + "Mark2: " + r.getMark2());
                                } else {
                                    System.out.println("Didn't find Cours results of Name: " + findCourseName + " Please try again later");
                                }
                            }
                            default -> System.out.println("Pleae entre your choice number 1 or 2");
                        }
                    }
                }
            }
            case 2 -> {
                System.out.println("Student First Name: ");
                String stuFirstName = sc.next();
                System.out.println("Student Last Name: ");
                String stuLastName = sc.next();
                for (Results r : listResults) {
                    if (r.getStudent().getFirstName().equalsIgnoreCase(stuFirstName) && r.getStudent().getLastName().equalsIgnoreCase(stuLastName)) {
                        System.out.println("Which Course results you are looking for? Please entre course 1: Id or 2: Name. Your choice number: ");
                        int choiceNum = validateInputNum();
                        switch (choiceNum) {
                            case 1 -> {
                                System.out.println("Course Id: ");
                                int findId = validateInputNum();
                                if (r.getCourse().getId() == findId) {
                                    System.out.println("Student: " + r.getStudent().getFirstName() + " " + r.getStudent().getLastName() + "   "
                                            + "Course: " + r.getCourse().getCourseName() + "   "
                                            + "Mark1: " + r.getMark1() + "   "
                                            + "Mark2: " + r.getMark2());
                                } else {
                                    System.out.println("Didn't find Cours results of Id: " + findId + " Please try again later");
                                }
                            }
                            case 2 -> {
                                System.out.println("Course Name: ");
                                String findCourseName = sc.next();
                                if (r.getCourse().getCourseName().equalsIgnoreCase(findCourseName)) {
                                    System.out.println("Student: " + r.getStudent().getFirstName() + " " + r.getStudent().getLastName() + "   "
                                            + "Course: " + r.getCourse().getCourseName() + "   "
                                            + "Mark1: " + r.getMark1() + "   "
                                            + "Mark2: " + r.getMark2());
                                } else {
                                    System.out.println("Didn't find Cours results of Name: " + findCourseName + " Please try again later");
                                }
                            }
                            default -> System.out.println("Pleae entre your choice number 1 or 2");
                        }
                    }
                }
            }
            default -> {
            }
        }
    }

    //Validation method
    public int validateInputNum() {
        Scanner sc = new Scanner(System.in);
        int inputNum;
        try {
            inputNum = sc.nextInt();
        } catch (Exception e) {
            System.out.println("This is not a number, please try again. ");
            return validateInputNum();
        }
        return inputNum;
    }

    public double validateInputDouble() {
        Scanner sc = new Scanner(System.in);
        double inputDouble;
        try {
            inputDouble = sc.nextDouble();
        } catch (Exception e) {
            System.out.println("This is not a double number, please try again. ");
            return validateInputDouble();
        }
        return inputDouble;
    }

}
