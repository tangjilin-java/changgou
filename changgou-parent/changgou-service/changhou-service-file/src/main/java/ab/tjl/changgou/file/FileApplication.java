package ab.tjl.changgou.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author:TangJiLin
 * @Description:启动类
 * @Date: Created in 2020/2/16 10:18
 * @Modified By:
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//排除数据库自动加载
@EnableEurekaClient
public class FileApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileApplication.class);
    }
}
