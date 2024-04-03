package com.akicat.knowledgeshare.eneity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.apache.ibatis.type.Alias;

/**
 * 用户信息实体类。
 */
public class UserEntity{
    // 用户ID
    private Integer userId;
    // 用户名
    private String userName;
    // 密码
    private String password;
    // email
    private String email;
    // 生日
    private LocalDate birthday;
    // 性别
    private Integer gender;
    // 年级
    private Integer grade;
    // 兴趣
    private String interest;
    // 自我介绍
    private String introduction;
    // 有效期开始时间
    private LocalDateTime validStartTime;
    // 有效期结束时间
    private LocalDateTime validEndTime;

    private Integer accessCode;

    private String deleteFlag;

    public UserEntity() {
        super();
    }

    public UserEntity(Integer userId, String userName, String password, String email, LocalDate birthday, Integer gender, Integer grade, String interest, String introduction,Integer accessCode) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.birthday = birthday;
        this.gender = gender;
        this.grade = grade;
        this.interest = interest;
        this.introduction = introduction;
        this.accessCode = accessCode;
    }

    public UserEntity(Integer userId, String userName) {
      super();
      this.userId = userId;
      this.userName = userName;
  }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
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
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public LocalDateTime getValidStartTime() {
        return validStartTime;
    }

    public void setValidStartTime(LocalDateTime validStartTime) {
        this.validStartTime = validStartTime;
    }

    public LocalDateTime getValidEndTime() {
        return validEndTime;
    }

    public void setValidEndTime(LocalDateTime validEndTime) {
        this.validEndTime = validEndTime;
    }

    public Integer getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(Integer accessCode) {
        this.accessCode = accessCode;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", grade=" + grade +
                ", interest='" + interest + '\'' +
                ", introduction='" + introduction + '\'' +
                ", validStartTime=" + validStartTime +
                ", validEndTime=" + validEndTime +
                ", accessCode=" + accessCode +
                '}';
    }
}
