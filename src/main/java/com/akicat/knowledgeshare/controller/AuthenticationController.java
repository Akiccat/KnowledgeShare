package com.akicat.knowledgeshare.controller;


import com.akicat.knowledgeshare.eneity.AuthTokenEntity;
import com.akicat.knowledgeshare.eneity.UserEntity;
import com.akicat.knowledgeshare.exception.BusinessFailureException;
import com.akicat.knowledgeshare.request.*;
import com.akicat.knowledgeshare.service.AuthenticationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    /**
     * TestPass
     * 用户登录。
     * <p>根据用户名、密码登录系统</p>
     *
     * @param form   用户名，密码。
     * @param errors 参数校验错误信息
     * @return 用户信息。
     */
    @PostMapping("/login")
    public UserEntity login(@RequestBody @Valid LoginRequestForm form, Errors errors) {
        if (errors.hasErrors()) {
            // 当form中存在验证错误，则抛出业务错误，将验证信息输出。
            throw new BusinessFailureException(errors);
        }
        UserEntity user = new UserEntity();
        BeanUtils.copyProperties(form, user);
        return authenticationService.login(user.getUserName(), user.getPassword());
    }

    /**
     * TestPass
     * 用户注册。
     * <p>根据用户输入的信息注册用户</p>
     *
     * @param form   注册表单。
     * @param errors 参数校验错误信息
     * @return 插入数据数
     */
    @PostMapping("/registration")
    public void registerUser(@RequestBody @Valid RegistrationForm form, Errors errors) {
        if (errors.hasErrors()) {
            // 当form中存在验证错误，则抛出业务错误，将验证信息输出。
            throw new BusinessFailureException(errors);
        }
        UserEntity user = new UserEntity();
        BeanUtils.copyProperties(form, user);
        if (form.getBirthday() != null) {
            user.setBirthday(LocalDate.parse(form.getBirthday(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        }
        //判断password
        if (form.getPassword().equals(form.getConfirmPassword())) {
            authenticationService.userRegister(user);
        } else {
            errors.rejectValue("confirmPassword", "", "密码校验失败");
            throw new BusinessFailureException(errors);
        }
    }

    /**
     * TestPass
     * 用户信息修改。
     * <p>根据用户输入的信息修改用户信息</p>
     *
     * @param form   表单。
     * @param errors 参数校验错误信息
     * @return 插入数据数
     */
    @PostMapping("/update")
    public void editUser(@RequestBody @Valid EditUserForm form, Errors errors) {
        if (errors.hasErrors()) {
            // 当form中存在验证错误，则抛出业务错误，将验证信息输出。
            throw new BusinessFailureException(errors);
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++"+form+"++++++++++++++++++++++++++++++++++++++++++++++++++");
        UserEntity user = new UserEntity();
        BeanUtils.copyProperties(form, user);
        if (form.getBirthday() != null) {
            user.setBirthday(LocalDate.parse(form.getBirthday(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++"+LocalDate.parse(form.getBirthday(), DateTimeFormatter.ofPattern("yyyy-MM-dd"))+"++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
        //判断password
        if (form.getPassword().equals(form.getConfirmPassword())) {
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++"+user+"++++++++++++++++++++++++++++++++++++++++++++++++++");
            authenticationService.editUser(user);
        } else {
            errors.rejectValue("confirmPassword", "", "密码校验失败");
            throw new BusinessFailureException(errors);
        }
    }

    @PostMapping("/getAllAdmin")
    public List<UserEntity> getAllAdmin() {
        return authenticationService.getAllAdmin();
    }

    @PostMapping("/getAllUser")
    public List<UserEntity> getAllUser() {
        return authenticationService.getAllUser();
    }
    @PostMapping("/getUser")
    public UserEntity getUser(@RequestBody EditUserForm form) {
        return authenticationService.getUserByUserId(form.getUserId());
    }
    @PostMapping("/searchUser")
    public List<UserEntity> searchUser(@RequestBody SearchForm form) {
        return authenticationService.searchUser(form.getSearchContent());
    }

    @PostMapping("/searchAdmin")
    public List<UserEntity> searchAdmin(@RequestBody SearchForm form) {
        return authenticationService.searchAdmin(form.getSearchContent());
    }

    @PostMapping("/banUser")
    public void banUser(@RequestBody BanUserForm form) {
        System.out.println(form.toString());
        authenticationService.banUser(form.getDeleteFlag(),form.getUserId());
    }
    @PostMapping("/setAsAdmin")
    public void setAsAdmin(@RequestBody SetAsAdminForm form) {
        System.out.println(form.toString());
        authenticationService.setAsAdmin(form.getUserId());
    }
    @PostMapping("/setAsUser")
    public void setAsUser(@RequestBody SetAsAdminForm form) {
        System.out.println(form.toString());
        authenticationService.setAsUser(form.getUserId());
    }
}
