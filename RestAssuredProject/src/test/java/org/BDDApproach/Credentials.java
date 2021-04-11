package org.BDDApproach;

public class Credentials
{
    int userId;
    String pwd;

Credentials credentials = new Credentials();

    public void getUserId(int userId) {
        this.userId = userId;
    }
    public int setUserId(int setUserId){
        return setUserId;
    }

    protected void getPwd(String pwd) {
        this.pwd = pwd;
    }

    public String setPwd(String setPwd){
        return pwd;
    }
}
