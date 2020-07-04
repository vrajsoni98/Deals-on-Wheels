package com.example.adminsidedealsonwheels.ui.dashboard;

public class DashboardPOJOCleint
{

    String cid,fname,lname,uemail,lnum,bdate,cnum,uid ;


    DashboardPOJOCleint()
    {}

    public DashboardPOJOCleint(String cid, String fname, String lname, String uemail, String lnum, String bdate, String cnum, String uid) {
        this.cid = cid;
        this.fname = fname;
        this.lname = lname;
        this.uemail = uemail;
        this.lnum = lnum;
        this.bdate = bdate;
        this.cnum = cnum;
        this.uid = uid;
    }


    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public String getLnum() {
        return lnum;
    }

    public void setLnum(String lnum) {
        this.lnum = lnum;
    }

    public String getBdate() {
        return bdate;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    public String getCnum() {
        return cnum;
    }

    public void setCnum(String cnum) {
        this.cnum = cnum;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
