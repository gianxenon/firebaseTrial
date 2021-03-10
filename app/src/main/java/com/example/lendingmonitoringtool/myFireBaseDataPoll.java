package com.example.lendingmonitoringtool;

public class myFireBaseDataPoll {

    String fn,ln,bday,num,eml,pass,nofit_stat;

    public myFireBaseDataPoll() {
    }



    public myFireBaseDataPoll(String fn, String ln, String bday, String num, String eml, String pass, String nofit_stat) {
        this.fn = fn;
        this.ln = ln;
        this.bday = bday;
        this.num = num;
        this.eml = eml;
        this.pass = pass;
        this.nofit_stat = nofit_stat;
    }

    public String getFn() {
        return fn;
    }

    public void setFn(String fn) {
        this.fn = fn;
    }

    public String getLn() {
        return ln;
    }

    public void setLn(String ln) {
        this.ln = ln;
    }

    public String getBday() {
        return bday;
    }

    public void setBday(String bday) {
        this.bday = bday;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getEml() {
        return eml;
    }

    public void setEml(String eml) {
        this.eml = eml;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNofit_stat() {
        return nofit_stat;
    }

    public void setNofit_stat(String nofit_stat) {
        this.nofit_stat = nofit_stat;
    }
}
