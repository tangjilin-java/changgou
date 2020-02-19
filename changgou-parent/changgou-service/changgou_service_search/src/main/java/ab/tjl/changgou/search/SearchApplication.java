package ab.tjl.changgou.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @Author:TangJiLin
 * @Description:启动类
 * @Date: Created in 2020/2/19 15:30
 * @Modified By:
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaClient
@EnableFeignClients(basePackages = {"ab.tjl.changgou.goods.feign"})
@EnableElasticsearchRepositories(basePackages = {"ab.tjl.changgou.search.dao"})
public class SearchApplication {
    public static void main(String[] args) {
        /**
         * 解决netty冲突后初始化client时还会抛出异常
         */
        System.setProperty("es.set.netty.runtime.available.processors","false");
        SpringApplication.run(SearchApplication.class);
    }
}
