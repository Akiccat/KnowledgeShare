package com.akicat.knowledgeshare.eneity;

import java.time.LocalDateTime;

public class AuthEntity {
    private String userId;
    private String password;
    private Integer loginFailedCount;
    private String accountLockFlag;
    private LocalDateTime accountLockDate;
    private LocalDateTime passwordLastUpdateTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getLoginFailedCount() {
        return loginFailedCount;
    }

    public void setLoginFailedCount(Integer loginFailedCount) {
        this.loginFailedCount = loginFailedCount;
    }

    public String getAccountLockFlag() {
        return accountLockFlag;
    }

    public void setAccountLockFlag(String accountLockFlag) {
        this.accountLockFlag = accountLockFlag;
    }

    public LocalDateTime getAccountLockDate() {
        return accountLockDate;
    }

    public void setAccountLockDate(LocalDateTime accountLockDate) {
        this.accountLockDate = accountLockDate;
    }

    public LocalDateTime getPasswordLastUpdateTime() {
        return passwordLastUpdateTime;
    }

    public void setPasswordLastUpdateTime(LocalDateTime passwordLastUpdateTime) {
        this.passwordLastUpdateTime = passwordLastUpdateTime;
    }
}
