/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TpTaoImp;

import InterfaceDao.CourseDao;
import Model.Course;
import TpDaoMain.GlobalMethod;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jeanl
 */
public class CourseDaoImp implements CourseDao {

    private final List<Course> listCourses;
    Scanner sc = new Scanner(System.in);
    GlobalMethod tpMethod = new GlobalMethod();

    public CourseDaoImp() {
        listCourses = new ArrayList<>();
    }

    @Override
    public List<Course> findAll() {
        return listCourses;
    }

    @Override
    public void create(Course course) {
        System.out.println("How many courses you want to create?");
        int numCreate = tpMethod.validateInputInt();
        int courseNum = 0;
        while (courseNum < numCreate) {
            System.out.println("Course ID: ");
            int id = tpMethod.validateInputInt();
            System.out.println("Course Name: ");
            String courseName = sc.next();
            course = new Course(id, courseName);

            listCourses.add(course);
            courseNum++;
        }
    }

    @Override
    public void delete(Course course) {
      //   Use iterator to delete
        Iterator<Course> itr = this.findCourse(course);
        System.out.println("Are you sure want to delete this course?  Y/N?");
        String answer = sc.next().toUpperCase();
        if (answer=="Y");
        itr.remove();
    }

    @Override
    public void update(Course course) {
        System.out.println("Update course Id number is: ");
        int updateId = tpMethod.validateInputInt();
        boolean findId = false;
        for (Course c: listCourses) {
            if (c.getId() == updateId) {
                findId = true;
                System.out.println("New Id: ");
                c.setId(tpMethod.validateInputInt());
                System.out.println("New Name: ");
                c.setCourseName(sc.next());
            }
        }
        if (!findId){
            System.out.println("The course Id is not exist!");
        }
    }

    @Override
    public void display(Course course) {
        System.out.println("Cours list");
        System.out.println(" ID : " + "         " + " Cours Name : ");

        listCourses.forEach((c) -> System.out.println(c.getId() + "              "
                + c.getCourseName()));
        System.out.println("-------------------------------------------");
    }


    public Iterator<Course> findCourse(Course course) {
        Iterator<Course> itr = listCourses.iterator();
        System.out.println("Please entre course Id Number you are looking for: ");
        int findById = tpMethod.validateInputInt();
        boolean hasId = false;
        while (itr.hasNext()){
           course = itr.next();
            if (course.getId()==findById ) {
                hasId = true;
                System.out.println("Find course with Id: " + course.getId() + ", Name: " + course.getCourseName());
            }
        }
        if (!hasId) {
            System.out.println("The Id number is not exist!");
        }
        return itr;
    }

}
