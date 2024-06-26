/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package elearning.ui.student;

import elearning.models.StudentCertModel;
import elearning.models.StudentCourseModel;
import elearning.models.StudentDataModel;
import elearning.models.UserModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Snehal
 */
public class StudentCertificateRequestPanel extends javax.swing.JPanel {

    JPanel studentContentPanel;
    StudentDataModel studentDataObj;
    UserModel userObj;

    /**
     * Creates new form StudentCertificateRequestPanel
     *
     * @param studentContentPanel
     * @param studentDataObj
     * @param userObj
     */
    public StudentCertificateRequestPanel(JPanel studentContentPanel,
            StudentDataModel studentDataObj,
            UserModel userObj) {
        initComponents();
        this.studentDataObj = studentDataObj;
        this.userObj = userObj;

        this.RequestCertificateButton.setEnabled(false);
        this.DownloadCertificateButton.setEnabled(false);

        loadTableData();

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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        RequestCertificateButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        DownloadCertificateButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Request Course Completion Certificate");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sno", "Course", "Subject", "Term","Professor",
                "Start Date", "End Date", "Status","Grade"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        RequestCertificateButton.setBackground(new java.awt.Color(51, 153, 255));
        RequestCertificateButton.setText("Request Ceritificate");
        RequestCertificateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RequestCertificateButtonActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("<html>Request Certificate, button will be enabled only if </br>"
            + "the Student successfully completed 8 courses through out the academics.<html>");

        DownloadCertificateButton.setBackground(new java.awt.Color(51, 153, 255));
        DownloadCertificateButton.setText("Download Certificate");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(107, 107, 107))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(RequestCertificateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DownloadCertificateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(RequestCertificateButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DownloadCertificateButton)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void RequestCertificateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RequestCertificateButtonActionPerformed
        // TODO add your handling code here:
        String studentName = userObj.getFullName();

        StudentCertModel studentCertObj = new StudentCertModel();
        studentCertObj.setStudentName(studentName);
        studentCertObj.setReqCertificateFlg("R");

        this.studentDataObj.getStudentCertObj().add(studentCertObj);

        JOptionPane.showMessageDialog(null, "Certificate Requested !");
        this.RequestCertificateButton.setEnabled(false);
    }//GEN-LAST:event_RequestCertificateButtonActionPerformed

    private void loadTableData() {
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        if (this.studentDataObj.getStudentCourseLi() != null
                && !this.studentDataObj.getStudentCourseLi().isEmpty()) {
            int rowIndex = 1;
            int statIndex = 1;
            for (StudentCourseModel studCourseObj : this.studentDataObj.getStudentCourseLi()) {
                if (studCourseObj.getStudentName().equalsIgnoreCase(userObj.getFullName())) {
                    Object[] row = new Object[9];
                    row[0] = rowIndex;
                    row[1] = studCourseObj.getCourseName();
                    row[2] = studCourseObj.getSubjectName();
                    row[3] = studCourseObj.getSemisterName();
                    row[4] = studCourseObj.getProfessorName();
                    row[5] = studCourseObj.getStartDate();
                    row[6] = studCourseObj.getEndDate();
                    row[7] = studCourseObj.getStatus();
                    row[8] = studCourseObj.getGrade();

                    if (studCourseObj.getStatus().equalsIgnoreCase("Completed")) {
                        statIndex++;
                    }

                    dtm.addRow(row);
                    rowIndex++;
                }
            }
            System.out.println("statIndex ::" + statIndex);
           
            if (statIndex >= 8) {
                this.RequestCertificateButton.setEnabled(true);
            }

            if (this.studentDataObj.getStudentCertObj() != null
                    && !this.studentDataObj.getStudentCertObj().isEmpty()) {
                for (StudentCertModel studentCertObj : this.studentDataObj.getStudentCertObj()) {
                    if (studentCertObj.getStudentName().equalsIgnoreCase(userObj.getFullName())) {
                        if (studentCertObj.getIssueCertificateFlg() != null
                                && studentCertObj.getIssueCertificateFlg().equalsIgnoreCase("I")) {
                            this.DownloadCertificateButton.setEnabled(true);
                            this.RequestCertificateButton.setVisible(false);
                            jLabel2.setText("");
                            jLabel2.setText("Certificate Issued...");
                            break;
                        }
                        if (studentCertObj.getReqCertificateFlg() != null
                                && studentCertObj.getReqCertificateFlg().equalsIgnoreCase("R")) {
                            this.DownloadCertificateButton.setEnabled(false);
                            this.RequestCertificateButton.setVisible(false);
                            jLabel2.setText("");
                            jLabel2.setText("Certificate Requested. Waiting for Approval...");
                            break;
                        }
                    }
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DownloadCertificateButton;
    private javax.swing.JButton RequestCertificateButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
