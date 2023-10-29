package org.example;

import java.util.List;

//여러개의 Course 정보를 가진 클래스
public class Courses {
    private final List<Course> courses;

    public Courses(List<Course> courses) {
        this.courses = courses;
    }

    public double multiplyCreditAndCourseGrade() {
        //(학점수 x 교과목 평점)의 합계
        double multipliedCreditAndCourseGrade = 0;

        //내부 로직이 바꾸면 모두 다른 클래스에서 사용하는 경우 모두 바꿔줘야 하므로 응집도가 낮다. -> Course에서 수행
        /*
            for (Course course : courses) {
                multipliedCreditAndCourseGrade += course.getCredit() * course.getGradeToNumber();
            }
         */

        //이 코드를 아래 스트림으로 변경하여 리팩토링
        /*
            for (Course course : courses) {
                multipliedCreditAndCourseGrade += course.multiplyCreditAndCourseGrade();
            }
            return multipliedCreditAndCourseGrade;
         */

        return courses.stream()
                .mapToDouble(Course::multiplyCreditAndCourseGrade)
                .sum();


    }

    public int calculateTotalCompletedCredit() {
        //수강신청 총학점 수
        return courses.stream()
                .mapToInt(Course::getCredit)
                .sum();


    }
}
