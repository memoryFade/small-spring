package com.memoryFaded.springframework.test.bean;

public class UserService {
    private String uId;
    private String company;
    private String location;
    private UserDao userDao;

    public String queryUserInfo() {
        return userDao.queryUserName(uId)+", 公司："+company+", 地点"+location;
    }
    public String getuId () {
        return uId;
    }

    public void setuId (String uId){
        this.uId = uId;
    }

    public UserDao getUserDao () {
        return userDao;
    }

    public void setUserDao (UserDao userDao){
        this.userDao = userDao;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String Company) {
        this.company = Company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
