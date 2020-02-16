package ab.tjl.changgou.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author:TangJiLin
 * @Description:启动类
 * @Date: Created in 2020/2/15 14:44
 * @Modified By:
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"ab.tjl.changgou.goods.dao"}) //开启通用mapper的包扫描
public class GoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class);
    }
}
