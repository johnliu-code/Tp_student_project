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
        int numCreate = tpMethod.validateInputaNum();
        int courseNum = 0;
        while (courseNum < numCreate) {
            System.out.println("Course ID: ");
            int id = tpMethod.validateInputaNum();
            System.out.println("Course Name: ");
            String courseName = sc.next();
            course = new Course(id, courseName);

            listCourses.add(course);
            courseNum++;
        }
    }

    @Override
    public void delete(Course course) {
        System.out.println("Delete Course by Id, please entre Id number: ");
        int deleteId = tpMethod.validateInputaNum();
        for (Course c : listCourses) {
            if (c.getId() == deleteId) {
                System.out.println("Id: " + c.getId() + "   " + "Name: " + c.getCourseName() + ";  "
                        + "Make sure you want to delete it? Y/N ?");
                String answer = sc.next().toUpperCase();
                if ("Y".equals(answer)) {
                    listCourses.remove(c);
                } else {
                    break;
                }
            }
        }
    }

    @Override
    public void update(Course course) {
        System.out.println("Update course by Id, please entre Id number: ");
        int updateId = tpMethod.validateInputaNum();

        for (Course c : listCourses) {
            if (c.getId() == updateId) {
                System.out.println("Id: " + c.getId() + "   " + "Name: " + c.getCourseName());
                System.out.println("New Id: ");
                int id = tpMethod.validateInputaNum();
                c.setId(id);
                System.out.println("New Name: ");
                String courseName = sc.next();
                c.setCourseName(courseName);

                System.out.println("Id: " + c.getId() + "   Name: " + c.getCourseName());
            }

            break;
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

}
