package org.example;

import java.util.List;

public class GradeCalculator {
    private final Courses courses;

    public GradeCalculator(List<Course> courses) {
        this.courses = new Courses(courses);
    }
    public GradeCalculator(Courses courses) {
        this.courses = courses;
    }


//
//    private final List<Course> courses;
//
//    public GradeCalculator(List<Course> courses) {
//        this.courses = courses;
//    }

    public double calculateGrade() {
        //일급 컬렉션에게 계산을 위임
        double multipliedCreditAndCourseGrade = courses.multiplyCreditAndCourseGrade();
        int totalCompletedCredit = courses.calculateTotalCompletedCredit();

        return multipliedCreditAndCourseGrade / totalCompletedCredit;

    }
}
