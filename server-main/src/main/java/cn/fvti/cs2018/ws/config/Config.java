package cn.fvti.cs2018.ws.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author gsd
 * 系统配置文件读取配置
 */
@Component
@ConfigurationProperties("spring")
@Getter
@Setter
public class Config {
    
    private String email_pw;
    private String email_user;
}
