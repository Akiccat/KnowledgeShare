package com.akicat.knowledgeshare.eneity;

import java.time.LocalDateTime;

public class DeviceEntity {
    private String userId;
    private String deviceId;
    private String authToken;
    private LocalDateTime authTokenPublishDate;
    private LocalDateTime lastSyncDate;
    private String pushDeviceToken;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public LocalDateTime getAuthTokenPublishDate() {
        return authTokenPublishDate;
    }

    public void setAuthTokenPublishDate(LocalDateTime authTokenPublishDate) {
        this.authTokenPublishDate = authTokenPublishDate;
    }

    public LocalDateTime getLastSyncDate() {
        return lastSyncDate;
    }

    public void setLastSyncDate(LocalDateTime lastSyncDate) {
        this.lastSyncDate = lastSyncDate;
    }

    public String getPushDeviceToken() {
        return pushDeviceToken;
    }

    public void setPushDeviceToken(String pushDeviceToken) {
        this.pushDeviceToken = pushDeviceToken;
    }
}
