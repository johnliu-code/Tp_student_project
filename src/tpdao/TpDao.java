/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpdao;

import InterfaceDao.CourseDao;
import InterfaceDao.ResultsDao;
import InterfaceDao.StudentDao;
import Model.Course;
import Model.Results;
import Model.Student;
import TpTaoImp.CourseDaoImp;
import TpTaoImp.ResultsDaoImp;
import TpTaoImp.StudentDaoImp;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jeanl
 */
public class TpDao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Student       
        StudentDao studentDao = new StudentDaoImp();
        Student student = new Student();
        List<Student> liststudents = studentDao.findAll();
        // Course
        CourseDao courseDao = new CourseDaoImp();
        Course course = new Course();
        List<Course> listcourses = courseDao.findAll();
        // Results
        ResultsDao resultsDao = new ResultsDaoImp();
        Results results = new Results();
        List<Results> listResults = resultsDao.findAll();

        String backToMenu = "Y";
        while ("Y".equals(backToMenu)) {

            System.out.println("Which case you want to work for? 1: Student; 2: Course; 3: Results; 4: Quit? Please entre your choice number: ");
            int choiceMenuNum = sc.nextInt();

            switch (choiceMenuNum) {
                case 1:
                    String backStudentMenu = "Y";
                    while ("Y".equals(backStudentMenu)) {
                        System.out.println("Which work you want to do for managing Student data? 1: Create; 2: Delete; 3: Update; 4: Find; 5: Display");
                        int stuMenuOpt = sc.nextInt();
                        int hasStu = liststudents.size();

                        switch (stuMenuOpt) {
                            case 1:
                                studentDao.create(student);
                                break;
                            case 2:
                                if (hasStu != 0) {
                                    studentDao.delete(student);
                                } else {
                                    System.out.println("Please create Student records first");
                                    break;
                                }
                                break;
                            case 3:
                                if (hasStu != 0) {
                                    studentDao.update(student);
                                } else {
                                    System.out.println("Please create Student records first");
                                    break;
                                }

                                break;
                            case 4:
                                if (hasStu != 0) {
                                    studentDao.find(student);
                                } else {
                                    System.out.println("Please create Student records first");
                                    break;
                                }

                                break;
                            case 5:
                                if (hasStu != 0) {
                                    studentDao.display(student);
                                } else {
                                    System.out.println("Please create Student records first");
                                    break;
                                }

                                break;
                            default:
                                System.out.println("Please entre your choice number from 1 to 5");
                        }
                        System.out.println("Back to Student menu: Y/N?");
                        backStudentMenu = sc.next().toUpperCase();
                    }
                    break;
                case 2:
                    String backCourseMenu = "Y";
                    while ("Y".equals(backCourseMenu)) {
                        System.out.println("Which work you want to do for managing Student data? 1: Create; 2: Delete; 3: Update; 4: Display");
                        int courseMenuOpt = sc.nextInt();
                        int hasCourse = listcourses.size();

                        switch (courseMenuOpt) {
                            case 1:
                                courseDao.create(course);
                                break;
                            case 2:
                                if (hasCourse != 0) {
                                    courseDao.delete(course);
                                } else {
                                    System.out.println("Please create Course records first!");
                                    break;
                                }

                                break;
                            case 3:
                                if (hasCourse != 0) {
                                    courseDao.update(course);
                                } else {
                                    System.out.println("Please create Course records first!");
                                    break;
                                }
                                break;
                            case 4:
                                if (hasCourse != 0) {
                                    courseDao.display(course);
                                } else {
                                    System.out.println("Please create Course records first!");
                                    break;
                                }

                                break;
                            default:
                                System.out.println("Please entre your choice number from 1 to 4");
                        }
                        System.out.println("Back to Course menu: Y/N?");
                        backCourseMenu = sc.next().toUpperCase();
                    }
                    break;
                case 3:
                    int stuRecords = liststudents.size();
                    int courseRecords = listcourses.size();
                    if (stuRecords != 0) {
                        if (courseRecords != 0) {
                            String backResultsMenu = "Y";
                            while ("Y".equals(backResultsMenu)) {
                                System.out.println("Which work you want to do for managing Student data? 1: Create; 2: Delete; 3: Update; 4: Find; 5: Display");
                                int resultsMenuOpt = sc.nextInt();

                                switch (resultsMenuOpt) {
                                    case 1:
                                        resultsDao.create(liststudents, listcourses, 0, 0);
                                        break;
                                    case 2:
                                        resultsDao.delete(listResults);
                                        break;
                                    case 3:
                                        resultsDao.update(liststudents, listcourses, 0, 0);
                                        break;
                                    case 4:
                                        resultsDao.find(results);
                                        break;
                                    case 5:
                                        resultsDao.display(listResults);
                                        break;
                                    default:
                                        System.out.println("Please entre your choice number from 1 to 5");
                                }
                                System.out.println("Back to Results menu: Y/N?");
                                backResultsMenu = sc.next().toUpperCase();
                            }

                        } else {
                            System.out.println("There is no records for Courses, please create Course records first!");
                            break;
                        }

                    } else {
                        System.out.println("There is no records for Students, please create Student records first!");
                        break;
                    }

                    break;
                case 4:
                    break;

                default:
                    System.out.println("Please entre number from 1 to 3");
            }
            if (choiceMenuNum != 4) {
                System.out.println("Back to Main menu: Y/N?");
                backToMenu = sc.next().toUpperCase();
            } else {
                break;
            }

        }
    }
}
