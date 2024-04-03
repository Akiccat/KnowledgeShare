package com.akicat.knowledgeshare.repository;


import com.akicat.knowledgeshare.eneity.GetLoginLogEntity;
import com.akicat.knowledgeshare.eneity.LoginLogEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 登录日志Mapper映射器。
 */
@Repository
public interface LoginLogRepository {

    /**
     * 新建登录日志。
     *
     * @param loginLog 登录日志信息
     */
    public void insert(LoginLogEntity loginLog);

    /**
     * 获取登录日志。
     *
     */
    List<GetLoginLogEntity> getLogs();
}
