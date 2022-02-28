/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author jeanl
 */
public class Results {

    Student student = new Student();
    Course course = new Course();

    private double mark1;
    private double mark2;

    public Results() {
    }

    public Results(Student student, Course course, double mark1, double mark2) {
        this.student = student;
        this.course = course;
        this.mark1 = mark1;
        this.mark2 = mark2;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public double getMark1() {
        return mark1;
    }

    public void setMark1(double mark1) {
        this.mark1 = mark1;
    }

    public double getMark2() {
        return mark2;
    }

    public void setMark2(double mark2) {
        this.mark2 = mark2;
    }

}
