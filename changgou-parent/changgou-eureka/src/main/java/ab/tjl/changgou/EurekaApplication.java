package ab.tjl.changgou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author:TangJiLin
 * @Description:Eureka启动类
 * @Date: Created in 2020/2/15 13:25
 * @Modified By:
 */
@SpringBootApplication
@EnableEurekaServer//开启eureka服务
public class EurekaApplication {

    /**
     * 加载启动类 以启动类为当前SpringBoot的配置标准
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class);
    }
}
