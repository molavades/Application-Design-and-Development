/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package elearning.models;

/**
 *
 * @author Snehal
 */
public class StudentCertModel {

    private String studentName;
    private String reqCertificateFlg;
    private String apprCertificateFlg;
    private String issueCertificateFlg;

    /**
     * @return the issueCertificateFlg
     */
    public String getIssueCertificateFlg() {
        return issueCertificateFlg;
    }

    /**
     * @param issueCertificateFlg the issueCertificateFlg to set
     */
    public void setIssueCertificateFlg(String issueCertificateFlg) {
        this.issueCertificateFlg = issueCertificateFlg;
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
     * @return the reqCertificateFlg
     */
    public String getReqCertificateFlg() {
        return reqCertificateFlg;
    }

    /**
     * @param reqCertificateFlg the reqCertificateFlg to set
     */
    public void setReqCertificateFlg(String reqCertificateFlg) {
        this.reqCertificateFlg = reqCertificateFlg;
    }

    /**
     * @return the apprCertificateFlg
     */
    public String getApprCertificateFlg() {
        return apprCertificateFlg;
    }

    /**
     * @param apprCertificateFlg the apprCertificateFlg to set
     */
    public void setApprCertificateFlg(String apprCertificateFlg) {
        this.apprCertificateFlg = apprCertificateFlg;
    }

}
