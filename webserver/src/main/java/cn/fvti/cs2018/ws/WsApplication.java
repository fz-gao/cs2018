package cn.fvti.cs2018.ws;

/**
 * Created by gsd on 2018/12/12.
 */
import cn.fvti.cs2018.ws.module.WsModule;
import org.springframework.boot.SpringApplication;

public class WsApplication {
    public static void main(String[] args) {
        SpringApplication.run(WsModule.class, args);
    }
}