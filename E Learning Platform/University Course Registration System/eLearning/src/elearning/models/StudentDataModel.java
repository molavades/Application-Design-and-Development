/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package elearning.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Snehal
 */
public class StudentDataModel {

    private List<StudentCourseModel> studentCourseLi = new ArrayList<>();

    private List<StudentCertModel> studentCertObj = new ArrayList<>();

    /**
     * @return the studentCertObj
     */
    public List<StudentCertModel> getStudentCertObj() {
        return studentCertObj;
    }

    /**
     * @param studentCertObj the studentCertObj to set
     */
    public void setStudentCertObj(List<StudentCertModel> studentCertObj) {
        this.studentCertObj = studentCertObj;
    }

    /**
     * @return the studentCourseLi
     */
    public List<StudentCourseModel> getStudentCourseLi() {
        return studentCourseLi;
    }

    /**
     * @param studentCourseLi the studentCourseLi to set
     */
    public void setStudentCourseLi(List<StudentCourseModel> studentCourseLi) {
        this.studentCourseLi = studentCourseLi;
    }

}
