package com.example.adminsidedealsonwheels.ui.dashboard;

public class DashboardPOJOProvider
{
    String adharcard,uid,id,personemail,nameOfProvider,ctnum;


    DashboardPOJOProvider()
    {}

    public DashboardPOJOProvider(String adharcard, String uid, String id, String personemail, String nameOfProvider, String ctnum) {
        this.adharcard = adharcard;
        this.uid = uid;
        this.id = id;
        this.personemail = personemail;
        this.nameOfProvider = nameOfProvider;
        this.ctnum = ctnum;
    }

    public String getAdharcard() {
        return adharcard;
    }

    public void setAdharcard(String adharcard) {
        this.adharcard = adharcard;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPersonemail() {
        return personemail;
    }

    public void setPersonemail(String personemail) {
        this.personemail = personemail;
    }

    public String getNameOfProvider() {
        return nameOfProvider;
    }

    public void setNameOfProvider(String nameOfProvider) {
        this.nameOfProvider = nameOfProvider;
    }

    public String getCtnum() {
        return ctnum;
    }

    public void setCtnum(String ctnum) {
        this.ctnum = ctnum;
    }
}
