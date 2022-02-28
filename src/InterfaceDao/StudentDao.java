/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceDao;

import Model.Student;
import java.util.List;

/**
 *
 * @author jeanl
 */
public interface StudentDao {
    void create(Student student);
    void delete(Student student);
    void update(Student student);
    void find(Student student);
    void display(Student student);
    
    List<Student> findAll();
}
