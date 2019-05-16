package cn.fvti.cs2018.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author gsd
 */
@SpringBootApplication(scanBasePackages = "cn.fvti.cs2018.ws")
public class WsApplication {
    public static void main(String[] args) {
        SpringApplication.run(WsApplication.class, args);
    }
}