package com.akicat.knowledgeshare.request;

import javax.validation.constraints.NotBlank;

/**
 * 注册入力参数
 */
public class RegistrationForm {
    @NotBlank(message = "用户名不能为空。")
    private String userName;
    @NotBlank(message = "密码不能为空。")
    private String password;
    private String confirmPassword;
    private String email;
    private String birthday;
    private Integer gender;
    private Integer grade;
    private String Interest;
    private String introduction;

    public RegistrationForm() {
    }

    public RegistrationForm(String userName, String password, String confirmPassword, String email, String birthday, Integer gender, Integer grade, String interest, String introduction) {
        this.userName = userName;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.email = email;
        this.birthday = birthday;
        this.gender = gender;
        this.grade = grade;
        Interest = interest;
        this.introduction = introduction;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getInterest() {
        return Interest;
    }

    public void setInterest(String interest) {
        Interest = interest;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
