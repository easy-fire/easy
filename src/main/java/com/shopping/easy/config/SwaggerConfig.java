package com.shopping.easy.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *swagger.enabled的值 确定是否开启swagger，正式环境一般是需要关闭的，在yml文件里设置为false就行了，可根据springboot的多环境配置进行配置
 *@Author: easy-fire
 *@Description: SwaggerConfig
 *@Date: 2019/8/6
 *@Medified By:
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Value("${swagger.enabled}")
    private boolean enableSwagger;
    @Bean
    public Docket RecruitApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Recruit")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .pathMapping("")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.shopping.easy.controller"))
                .build()
                .apiInfo(RecruitApiInfo());
    }

    private ApiInfo RecruitApiInfo() {
        return new ApiInfoBuilder()
                .title("Here is the name for system")
                .description("name-system Server's REST API")
                .version("V1.0")
                .termsOfServiceUrl("NO terms of service")
                .contact(new Contact("easy.fire","","easy.fire@aorise.org"))
                .license("GPL")
                .licenseUrl("")
                .build();
    }
}
