package com.akicat.knowledgeshare.service.impl;

import com.akicat.knowledgeshare.eneity.LoginLogEntity;
import com.akicat.knowledgeshare.eneity.UserEntity;
import com.akicat.knowledgeshare.exception.BusinessFailureException;
import com.akicat.knowledgeshare.repository.LoginLogRepository;
import com.akicat.knowledgeshare.repository.UserRepository;
import com.akicat.knowledgeshare.service.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Service
@Primary
public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationServiceImpl.class);

    private Long tokenValidDates;
    private Integer tokenRetryTimes;
    private Integer oneTimeTokenValidDuration;
    private Integer tokenAccessLimitNumber;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoginLogRepository loginLogRepository;

    /**
     * 用户登录。
     * <p>根据用户名、密码登录系统</p>
     *
     * @param userName 用户名
     * @param password 密码
     * @return 用户信息
     */
    @Override
    public UserEntity login(String userName, String password) {
        // 根据用户名、密码查询用户信息。
        UserEntity user = userRepository.selectUserByNameAndPass(userName, password);
        LocalDateTime now = LocalDateTime.now();
        if (user == null || now.isBefore(user.getValidStartTime()) || now.isAfter(user.getValidEndTime())) {
            // 用户不存在，或不在有效期内，则抛出业务异常。
            throw new BusinessFailureException(false);
        }
        LoginLogEntity loginLog = new LoginLogEntity();
        loginLog.setUserId(user.getUserId());
        loginLog.setUserType(user.getAccessCode());
        loginLog.setLoginDateTime(LocalDateTime.parse(LocalDateTime.now().toString().substring(0,19).replaceAll("T"," "), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println(loginLog);
        // 新建登录日志。
        loginLogRepository.insert(loginLog);
        return user;
    }
    /**
     * 用户注册。
     * <p>根据用户输入的信息注册用户</p>
     *
     * @param form 用户的全部信息
     */
    @Override
    public Integer userRegister(UserEntity form) {
        form.setAccessCode(2);
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime endYear = now.plusYears(1);
        form.setValidEndTime(endYear);
        if (userRepository.getUser(null, form.getUserName()) == null) {
            if (userRepository.registerUser(form) == 0) {
                throw new BusinessFailureException(false);
            } else {
                return 1;
            }
        } else {
            throw new BusinessFailureException(false);
        }
    }

    /** TestPass
     * 用户修改。
     * <p>根据用户输入的信息修改用户</p>
     *
     * @param user 用户的全部信息
     */
    @Override
    public Integer editUser(UserEntity user) {
        if (userRepository.editUser(user) == 0) {
            throw new BusinessFailureException(false);
        } else {
            return 1;
        }
    }

    @Override
    public List<UserEntity> getAllUser() {
        if (userRepository.getAllUser().isEmpty()){
            throw new BusinessFailureException(true);
        }else {
            return userRepository.getAllUser();
        }
    }

    @Override
    public UserEntity getUserByUserId(Integer userId) {
        if (userRepository.getUserById(userId) == null){
            throw new BusinessFailureException(true);
        }else {
            return userRepository.getUserById(userId);
        }
    }

    @Override
    public List<UserEntity> getAllAdmin() {
        if (userRepository.getAllAdmin().isEmpty()){
            throw new BusinessFailureException(true);
        }else {
            return userRepository.getAllAdmin();
        }
    }

    @Override
    public List<UserEntity> searchUser(String searchContent) {
        if (userRepository.searchUser(searchContent) == null) {
            throw new BusinessFailureException(true);
        }
        return userRepository.searchUser(searchContent);
    }

    @Override
    public List<UserEntity> searchAdmin(String searchContent) {
        if (userRepository.searchAdmin(searchContent) == null) {
            throw new BusinessFailureException(true);
        }
        return userRepository.searchAdmin(searchContent);
    }

    @Override
    public void banUser(Integer deleteFlag, String userId) {
        if(userRepository.banUser(deleteFlag,userId) == 0){
            throw new BusinessFailureException(true);
        };
    }

    @Override
    public void setAsAdmin(String userId) {
        if(userRepository.setAsAdmin(userId) == 0){
            throw new BusinessFailureException(true);
        };
    }

    @Override
    public void setAsUser(String userId) {
        if(userRepository.setAsUser(userId) == 0){
            throw new BusinessFailureException(true);
        };
    }
}
