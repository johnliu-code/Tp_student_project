package TpDaoMain;

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

public class TpDaoMethod {
     //Create main menu with all the object menu method
     Scanner sc = new Scanner(System.in);

    // Student
    StudentDao studentDao = new StudentDaoImp();
    Student student = new Student();
    List<Student> listStudents = studentDao.findAll();
    // Course
    CourseDao courseDao = new CourseDaoImp();
    Course course = new Course();
    List<Course> listCourses = courseDao.findAll();
    // Results
    ResultsDao resultsDao = new ResultsDaoImp();
    Results results = new Results();
    List<Results> listResults = resultsDao.findAll();

    //Main menu
    public void mainMenu() {
        String  backToMain= "Y";
        while ("Y".equals(backToMain)) {
            System.out.println("Which case you want to work for? 1: Student; 2: Course; 3: Results; 4: Quit? Please entre your choice number: ");
            int choiceMenuNum = validateInputaNum();
            switch (choiceMenuNum) {
                case 1:
                    stuMenu();
                    break;
                case 2:
                    courseMenu();
                    break;
                case 3:
                    rsultsMenu();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Please entre number from 1 to 3");
            }
            if (choiceMenuNum != 4) {
                System.out.println("Back to Main menu: Y/N?");
                backToMain = sc.next().toUpperCase();
            }
        }
    }

    // Student menu
    public void stuMenu() {
        String backStuMenu = "Y";
        while (backStuMenu.equals("Y")) {
            System.out.println("Which work you want to do for managing Student data? 1: Create; 2: Delete; 3: Update; 4: Find; 5: Display");
            int stuMenuOpt = validateInputaNum();
            int hasStu = listStudents.size();

            switch (stuMenuOpt) {
                case 1:
                    studentDao.create(student);
                    break;
                case 2:
                    if (hasStu != 0) {
                        studentDao.delete(student, listResults);
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
            backStuMenu = sc.next().toUpperCase();
        }
    }

    // Course menu
    public void courseMenu() {
        String backCourseMenu = "Y";
        while ("Y".equals(backCourseMenu)) {
            System.out.println("Which work you want to do for managing Course data? 1: Create; 2: Delete; 3: Update; 4: Display");
            int courseMenuOpt = validateInputaNum();
            int hasCourse = listCourses.size();

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

    }

    // Results menu
    public void rsultsMenu() {
        int stuRecords = listStudents.size();
        int courseRecords = listCourses.size();
        if (stuRecords != 0) {
            if (courseRecords != 0) {
                String backResultsMenu = "Y";
                while ("Y".equals(backResultsMenu)) {
                    System.out.println("Which work you want to do for managing Results data? 1: Create; 2: Delete; 3: Update; 4: Find; 5: Display");
                    int resultsMenuOpt = validateInputaNum();

                    switch (resultsMenuOpt) {
                        case 1 -> resultsDao.create(listStudents, listCourses, 0, 0);
                        case 2 -> resultsDao.delete(listResults);
                        case 3 -> resultsDao.update(listStudents, listCourses, 0, 0);
                        case 4 -> resultsDao.find(results);
                        case 5 -> resultsDao.display(listResults);
                        default -> System.out.println("Please entre your choice number from 1 to 5");
                    }
                    System.out.println("Back to Results menu: Y/N?");
                    backResultsMenu = sc.next().toUpperCase();
                }

            } else {
                System.out.println("There is no records for Courses, please create Course records first!");
            }

        } else {
            System.out.println("There is no records for Students, please create Student records first!");
        }
    }

    //Validation checker
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
