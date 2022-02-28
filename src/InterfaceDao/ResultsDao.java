/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceDao;

import Model.Course;
import Model.Results;
import Model.Student;
import java.util.List;

/**
 *
 * @author jeanl
 */
public interface ResultsDao {

    void create(List<Student> listStudents, List<Course> listCourses, double mark1, double mark2);

    void delete(List<Results> listResults);

    void update(List<Student> listStudents, List<Course> listCourses, double mark1, double mark2);
    
    void find(Results results);

    void display(List<Results> listResults);
    
    List<Results> findAll();

}
