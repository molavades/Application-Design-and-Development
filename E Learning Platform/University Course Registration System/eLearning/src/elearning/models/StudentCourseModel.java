/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package elearning.models;

/**
 *
 * @author Snehal
 */
public class StudentCourseModel {

    private String studentName;
    private String semisterName;
    private String subjectName;
    private String courseName;
    private String professorName;
    private String startDate;
    private String endDate;
    private String status;
    private String certified;
    private String grade = "0";

    /**
     * @return the grade
     */
    public String getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * @return the studentName
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * @param studentName the studentName to set
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
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
     * @return the subjectName
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * @param subjectName the subjectName to set
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    /**
     * @return the courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * @param courseName the courseName to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

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
     * @return the startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
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
     * @return the certified
     */
    public String getCertified() {
        return certified;
    }

    /**
     * @param certified the certified to set
     */
    public void setCertified(String certified) {
        this.certified = certified;
    }

}
