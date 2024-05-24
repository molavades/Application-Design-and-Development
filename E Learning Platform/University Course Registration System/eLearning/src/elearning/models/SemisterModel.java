/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package elearning.models;

import java.util.List;

/**
 *
 * @author harsh
 */
public class SemisterModel {

    private String semisterName;
    private List<CourseModel> subjects;

    public SemisterModel() {

    }

    public SemisterModel(String semisterName, List<CourseModel> subjects) {
        this.semisterName = semisterName;
        this.subjects = subjects;
    }

    /**
     * @return the subjects
     */
    public List<CourseModel> getSubjects() {
        return subjects;
    }

    /**
     * @param subjects the subjects to set
     */
    public void setSubjects(List<CourseModel> subjects) {
        this.subjects = subjects;
    }

    /**
     * @return the semisterName
     */
    public String getSemisterName() {
        return semisterName;
    }

    /**
     * @param semisterName the semisterName to set
     */
    public void setSemisterName(String semisterName) {
        this.semisterName = semisterName;
    }

}
