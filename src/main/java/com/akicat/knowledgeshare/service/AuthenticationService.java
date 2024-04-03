package com.akicat.knowledgeshare.service;

import com.akicat.knowledgeshare.eneity.UserEntity;

import java.util.List;

public interface AuthenticationService {
    /**
     * 用户登录。
     * <p>根据用户名、密码登录系统</p>
     *
     * @param userName 用户名
     * @param password 密码
     * @return 用户信息
     */
    UserEntity login(String userName, String password);

    /**
     * 用户注册。
     * <p>根据用户输入的信息注册用户</p>
     *
     * @param user 用户的全部信息
     */
    public Integer userRegister(UserEntity user);

    /**
     * 用户修改。
     * <p>根据用户输入的信息修改用户信息</p>
     *
     * @param user 用户的全部信息
     */
    public Integer editUser(UserEntity user);

    List<UserEntity> getAllUser();
    UserEntity getUserByUserId(Integer userId);

    List<UserEntity> getAllAdmin();

    List<UserEntity> searchUser(String searchContent);

    List<UserEntity> searchAdmin(String searchContent);

    void banUser(Integer deleteFlag, String userId);

    void setAsAdmin(String userId);

    void setAsUser(String userId);
}
