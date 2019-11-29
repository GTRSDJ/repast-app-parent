package com.aaa.lee.app.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/10/21 9:10
 * @Description
 **/
@Component
@PropertySource("classpath:config/ftp.properties")
@ConfigurationProperties(prefix = "spring.ftp")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FtpProperties {
    private String host;
    private String port;
    private String username;
    private String password;
    private String basePath;
    private String httpPath;


}
