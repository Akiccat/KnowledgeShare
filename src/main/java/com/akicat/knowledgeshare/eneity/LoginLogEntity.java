package com.akicat.knowledgeshare.eneity;

import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 登录日志实体类。
 */
@Alias("LoginLog")
public class LoginLogEntity {
    // 日志ID
    private Integer logId;
    // 用户ID
    private Integer userId;
    // 用户权限
    private Integer userType;
    // 登录时间
    private LocalDateTime loginDateTime;

    public LoginLogEntity() {
        super();
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public LocalDateTime getLoginDateTime() {
        return loginDateTime;
    }

    public void setLoginDateTime(LocalDateTime loginDateTime) {
        this.loginDateTime = loginDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginLogEntity that = (LoginLogEntity) o;
        return Objects.equals(logId, that.logId) && Objects.equals(userId, that.userId) && Objects.equals(userType, that.userType) && Objects.equals(loginDateTime, that.loginDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logId, userId, userType, loginDateTime);
    }

    @Override
    public String toString() {
        return "LoginLogEntity{" +
                "logId=" + logId +
                ", userId=" + userId +
                ", userType=" + userType +
                ", loginDateTime=" + loginDateTime +
                '}';
    }
}
