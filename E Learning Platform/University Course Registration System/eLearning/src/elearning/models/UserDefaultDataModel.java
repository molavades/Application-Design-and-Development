/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package elearning.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author harsh
 */
public class UserDefaultDataModel {

    private List<CourseModel> coursesList = new ArrayList<>();
    private List<SemisterModel> semisterSubList = new ArrayList<>();

    /**
     * @return the coursesList
     */
    public List<CourseModel> getCoursesList() {
        return coursesList;
    }

    /**
     * @param coursesList the coursesList to set
     */
    public void setCoursesList(List<CourseModel> coursesList) {
        this.coursesList = coursesList;
    }

    /**
     * @return the semisterSubList
     */
    public List<SemisterModel> getSemisterSubList() {
        return semisterSubList;
    }

    /**
     * @param semisterSubList the semisterSubList to set
     */
    public void setSemisterSubList(List<SemisterModel> semisterSubList) {
        this.semisterSubList = semisterSubList;
    }

}
