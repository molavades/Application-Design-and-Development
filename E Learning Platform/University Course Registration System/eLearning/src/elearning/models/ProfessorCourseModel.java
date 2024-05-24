/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package elearning.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aayuka Nirawade
 */
public class ProfessorCourseModel {

    private String professorName;
    private String semisterName;
    private String subjectOne;
    private String status;
    private List<ProfCourseSubjectMapModel> profCourseSubjectLi = new ArrayList<>();

    /**
     * @return the professorName
     */
    public String getProfessorName() {
        return professorName;
    }

    /**
     * @param professorName the professorName to set
     */
    public void setProfessorName(String professorName) {
        this.professorName = professorName;
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

    /**
     * @return the subjectOne
     */
    public String getSubjectOne() {
        return subjectOne;
    }

    /**
     * @param subjectOne the subjectOne to set
     */
    public void setSubjectOne(String subjectOne) {
        this.subjectOne = subjectOne;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the profCourseSubjectLi
     */
    public List<ProfCourseSubjectMapModel> getProfCourseSubjectLi() {
        return profCourseSubjectLi;
    }

    /**
     * @param profCourseSubjectLi the profCourseSubjectLi to set
     */
    public void setProfCourseSubjectLi(List<ProfCourseSubjectMapModel> profCourseSubjectLi) {
        this.profCourseSubjectLi = profCourseSubjectLi;
    }

}
