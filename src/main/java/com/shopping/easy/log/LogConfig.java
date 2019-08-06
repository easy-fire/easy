package com.shopping.easy.log;

import com.shopping.easy.model.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *@Author : easy-fire
 *@Description : 日志示范
 *@Date : 2019/8/6
 *@Medified By:
 */
@Configuration
public class LogConfig {
    private static final Logger LOG = LoggerFactory.getLogger(LogConfig.class);

    @Bean
    public UserModel logMethod(){
        LOG.info("=============print log================");
        return new UserModel();
    }
}
