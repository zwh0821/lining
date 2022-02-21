package com.isuperone.lining.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

/**
 * @program: Lining
 * @description: 上传文件目录配置
 * @author: Joe
 * @create: 2020-05-18 17:24
 **/
@Configuration
public class UploadFileConfig {

    @Value("${file.uploadFolder}")
    private String uploadFolder;

    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation(uploadFolder);
        //文件最大
        factory.setMaxFileSize(DataSize.ofKilobytes(10240));
        // 设置总上传数据总大小
        factory.setMaxRequestSize(DataSize.ofKilobytes(20480));
        return factory.createMultipartConfig();
    }

}
