/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package elearning.ui.student;

import elearning.models.ProfessorDataModel;
import elearning.models.ProfessorRatingModel;
import elearning.models.StudentCourseModel;
import elearning.models.StudentDataModel;
import elearning.models.UserDefaultDataModel;
import elearning.models.UserModel;
import java.util.HashSet;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Snehal
 */
public class StudentRateProfessorPanel extends javax.swing.JPanel {

    JPanel studentContentPanel;
    UserModel userObj;
    UserDefaultDataModel userDefaultDataObj;
    ProfessorDataModel professorDataObj;
    StudentDataModel studentDataObj;

    /**
     * Creates new form StudentRateProfessorPanel
     *
     * @param studentContentPanel
     * @param professorDataObj
     * @param userDefaultDataObj
     * @param userObj
     * @param studentDataObj
     */
    public StudentRateProfessorPanel(JPanel studentContentPanel,
            ProfessorDataModel professorDataObj,
            UserDefaultDataModel userDefaultDataObj,
            UserModel userObj,
            StudentDataModel studentDataObj) {
        initComponents();

        this.studentContentPanel = studentContentPanel;
        this.professorDataObj = professorDataObj;
        this.userDefaultDataObj = userDefaultDataObj;
        this.userObj = userObj;
        this.studentDataObj = studentDataObj;

        this.errorLable.setText("");

        loadTermDetails();
        loadRatingDetails();

        loadTableData();
    }

    private void loadTermDetails() {
        DefaultComboBoxModel dcb = (DefaultComboBoxModel) termCB.getModel();
        dcb.removeAllElements();
        dcb.addElement("Select");
        Set<String> termSet = new HashSet<>();
        if (this.studentDataObj.getStudentCourseLi() != null
                && !this.studentDataObj.getStudentCourseLi().isEmpty()) {
            for (StudentCourseModel stuCourseObj : studentDataObj.getStudentCourseLi()) {
                //dcb.addElement(stuCourseObj.getSemisterName());
                termSet.add(stuCourseObj.getSemisterName());
            }
            if (!termSet.isEmpty()) {
                dcb.addAll(termSet);
            }
        }
    }

    private void loadRatingDetails() {
        DefaultComboBoxModel dcb = (DefaultComboBoxModel) ratingCB.getModel();
        dcb.removeAllElements();
        dcb.addElement("Select");

        dcb.addElement(new rating(1, "(*)"));
        dcb.addElement(new rating(2, "(* *)"));
        dcb.addElement(new rating(3, "(* * *)"));
        dcb.addElement(new rating(4, "(* * * *)"));
        dcb.addElement(new rating(5, "(* * * * *)"));

    }

    private void loadSubjectDetails(final String termName) {
        if (this.studentDataObj.getStudentCourseLi() != null
                && !this.studentDataObj.getStudentCourseLi().isEmpty()) {
            DefaultComboBoxModel subcb = (DefaultComboBoxModel) subjectCB.getModel();
            subcb.removeAllElements();
            subcb.addElement("Select");
            Set<String> subSet = new HashSet<>();
            for (StudentCourseModel stuCourseObj : studentDataObj.getStudentCourseLi()) {
                if (stuCourseObj.getSemisterName().equalsIgnoreCase(termName)) {
                    subSet.add(stuCourseObj.getSubjectName());
                }
            }
            if (!subSet.isEmpty()) {
                subcb.addAll(subSet);
            }
        }
    }

    private void loadCourseDetails(final String termName, final String subjectName) {
        if (this.studentDataObj.getStudentCourseLi() != null
                && !this.studentDataObj.getStudentCourseLi().isEmpty()) {
            DefaultComboBoxModel coursecb = (DefaultComboBoxModel) courseCB.getModel();
            coursecb.removeAllElements();
            coursecb.addElement("Select");
            int index = 0;
            Set<String> coursSet = new HashSet<>();
            for (StudentCourseModel stuCourseObj : studentDataObj.getStudentCourseLi()) {
                if ((stuCourseObj.getSemisterName().equalsIgnoreCase(termName))
                        && (stuCourseObj.getSubjectName().equalsIgnoreCase(subjectName))
                        && (stuCourseObj.getStatus().equalsIgnoreCase("Completed"))) {
                    coursSet.add(stuCourseObj.getCourseName());
                    index++;
                }
            }
            if (!coursSet.isEmpty()) {
                coursecb.addAll(coursSet);
            }
            if (index == 0) {
                errorLable.setText("Registered Courses are still not completed to Rate.");
            }
        }
    }

    private void loadProfessorDetails(final String courseName) {
        DefaultComboBoxModel profcb = (DefaultComboBoxModel) professorCB.getModel();
        profcb.removeAllElements();
        profcb.addElement("Select");
        Set<String> profSet = new HashSet<>();
        if (this.studentDataObj.getStudentCourseLi() != null
                && !this.studentDataObj.getStudentCourseLi().isEmpty()) {
            for (StudentCourseModel stuCourseObj : studentDataObj.getStudentCourseLi()) {
                if ((stuCourseObj.getCourseName().equalsIgnoreCase(courseName))
                        && (stuCourseObj.getStatus().equalsIgnoreCase("Completed"))) {
                    profSet.add(stuCourseObj.getProfessorName());
                }
            }

            if (!profSet.isEmpty()) {
                profcb.addAll(profSet);
            }
        }
    }

    private void loadProfRatingDetails(final String profName) {
        if (this.professorDataObj.getProfessorRatingLi() != null
                && !this.professorDataObj.getProfessorRatingLi().isEmpty()) {
            for (ProfessorRatingModel rateObj : this.professorDataObj.getProfessorRatingLi()) {
                if ((rateObj.getProfessorName().equalsIgnoreCase(profName))
                        && (rateObj.getStudentName().equalsIgnoreCase(userObj.getUsername()))) {

                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        termCB = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        subjectCB = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        courseCB = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        professorCB = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        ratingCB = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        errorLable = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Rate Professor");

        jLabel2.setText("Term/ Semister  :");

        termCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        termCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                termCBActionPerformed(evt);
            }
        });

        jLabel3.setText("Subject  :");

        subjectCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        subjectCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectCBActionPerformed(evt);
            }
        });

        jLabel4.setText("Course  :");

        courseCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        courseCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseCBActionPerformed(evt);
            }
        });

        jLabel5.setText("Professor  :");

        professorCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        professorCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                professorCBActionPerformed(evt);
            }
        });

        jLabel6.setText("Rating  :");

        ratingCB.setModel(new javax.swing.DefaultComboBoxModel<>(
            new String[] { })
    );

    jTable1.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {},
        new String [] {
            "Sno", "Professor", "Term", "Subject", "Course","Rating"
        }
    ));
    jScrollPane1.setViewportView(jTable1);

    jButton1.setBackground(new java.awt.Color(51, 153, 255));
    jButton1.setText("Rate");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }
    });

    errorLable.setForeground(new java.awt.Color(255, 0, 0));
    errorLable.setText("jLabel7");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jSeparator1)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(289, Short.MAX_VALUE)
            .addComponent(jLabel1)
            .addGap(232, 232, 232))
        .addGroup(layout.createSequentialGroup()
            .addGap(17, 17, 17)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel4)
                        .addComponent(jLabel6))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(termCB, 0, 197, Short.MAX_VALUE)
                        .addComponent(courseCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ratingCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(errorLable))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(57, 57, 57)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel5))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(professorCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(subjectCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1)
                    .addGap(12, 12, 12)))
            .addContainerGap())
        .addGroup(layout.createSequentialGroup()
            .addComponent(jSeparator2)
            .addContainerGap())
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane1)
            .addContainerGap())
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(48, 48, 48)
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(termCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(subjectCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(courseCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(professorCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(27, 27, 27)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(ratingCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                    .addComponent(jButton1))
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(errorLable)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(14, 14, 14))
    );
    }// </editor-fold>//GEN-END:initComponents

    private void termCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_termCBActionPerformed
        // TODO add your handling code here:
        if (this.termCB.getSelectedItem() != null) {
            String termName = this.termCB.getSelectedItem().toString();
            if (termName.equalsIgnoreCase("Select")) {
                this.termCB.removeAllItems();
            } else {
                loadSubjectDetails(termName);
            }
        }
    }//GEN-LAST:event_termCBActionPerformed

    private void subjectCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectCBActionPerformed
        // TODO add your handling code here:
        if (this.subjectCB.getSelectedItem() != null) {
            String termName = this.termCB.getSelectedItem().toString();
            String subName = this.subjectCB.getSelectedItem().toString();
            if (termName.equalsIgnoreCase("Select")) {
                this.subjectCB.removeAllItems();
            } else if (!(termName.equalsIgnoreCase("Select"))
                    && !(subName.equalsIgnoreCase("Select"))) {
                loadCourseDetails(termName, subName);
            }
        }
    }//GEN-LAST:event_subjectCBActionPerformed

    private void courseCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseCBActionPerformed
        // TODO add your handling code here:
        if (this.courseCB.getSelectedItem() != null) {
            errorLable.setText("");
            String courseName = this.courseCB.getSelectedItem().toString();
            if (courseName.equalsIgnoreCase("Select")) {
                this.courseCB.removeAllItems();
            } else if (!courseName.equalsIgnoreCase("Select")) {
                loadProfessorDetails(courseName);
            }
        }
    }//GEN-LAST:event_courseCBActionPerformed

    private void professorCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_professorCBActionPerformed
        // TODO add your handling code here:
        if (this.professorCB.getSelectedItem() != null) {
            String courseName = this.courseCB.getSelectedItem().toString();
            String profName = this.professorCB.getSelectedItem().toString();
            if (!courseName.equalsIgnoreCase("Select")
                    && !profName.equalsIgnoreCase("Select")) {

            }
        }
    }//GEN-LAST:event_professorCBActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (this.ratingCB.getSelectedItem() != null) {
            int rating = this.ratingCB.getSelectedIndex();
            String profName = this.professorCB.getSelectedItem().toString();
            String courseName = this.courseCB.getSelectedItem().toString();
            if (this.professorDataObj.getProfessorRatingLi() != null) {
                ProfessorRatingModel rateObj = new ProfessorRatingModel();

                rateObj.setProfessorName(profName);
                rateObj.setRating(rating);
                rateObj.setStudentName(userObj.getFullName());
                rateObj.setCourseName(courseName);

                this.professorDataObj.getProfessorRatingLi().add(rateObj);
            }
        }

        loadTableData();
    }//GEN-LAST:event_jButton1ActionPerformed

    //"Sno", "Professor", "Term", "Subject", "Course","Rating"
    private void loadTableData() {
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        if (this.studentDataObj.getStudentCourseLi() != null
                && !this.studentDataObj.getStudentCourseLi().isEmpty()) {
            int rowIndex = 1;
            for (StudentCourseModel studCourseObj : this.studentDataObj.getStudentCourseLi()) {
                if (studCourseObj.getStudentName().equalsIgnoreCase(userObj.getFullName())) {
                    Object[] row = new Object[8];
                    row[0] = rowIndex;
                    row[1] = studCourseObj.getProfessorName();
                    row[2] = studCourseObj.getSemisterName();
                    row[3] = studCourseObj.getSubjectName();
                    row[4] = studCourseObj.getCourseName();

                    int rating = 0;
                    int ratingCount = 0;
                    int ratingTotal = 0;

                    if (this.professorDataObj.getProfessorRatingLi() != null
                            && !this.professorDataObj.getProfessorRatingLi().isEmpty()) {
                        for (ProfessorRatingModel rateObj : this.professorDataObj.getProfessorRatingLi()) {
                            if ((rateObj.getProfessorName().equalsIgnoreCase(studCourseObj.getProfessorName())
                                    && (rateObj.getCourseName().equalsIgnoreCase(studCourseObj.getCourseName())))) {
                                ratingCount++;
                                ratingTotal = ratingTotal + rateObj.getRating();
                            }
                        }
                    }
                    rating = (ratingCount > 0) ? Math.round(ratingTotal / ratingCount) : 0;
                    row[5] = rating > 0 ? rating : "Un Rated";
                    dtm.addRow(row);
                    rowIndex++;
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> courseCB;
    private javax.swing.JLabel errorLable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> professorCB;
    private javax.swing.JComboBox<String> ratingCB;
    private javax.swing.JComboBox<String> subjectCB;
    private javax.swing.JComboBox<String> termCB;
    // End of variables declaration//GEN-END:variables

    private class rating {

        private int id;
        private String ratingStar;

        public rating(int id, String ratingStar) {
            this.id = id;
            this.ratingStar = ratingStar;
        }

        public int getId() {
            return id;
        }

        public String getRatingStar() {
            return ratingStar;
        }

        @Override
        public String toString() {
            return ratingStar;
        }
    }
}
