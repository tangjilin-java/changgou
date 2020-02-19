package ab.tjl.changgou.goods.feign;

import ab.tjl.changgou.goods.pojo.Sku;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author:TangJiLin
 * @Description:
 * @Date: Created in 2020/2/19 15:57
 * @Modified By:
 */
@FeignClient(value = "goods")
@RequestMapping("/sku")
public interface SkuFeign {
    /**
     * 查询全部sku
     * @return
     */
    @GetMapping
    Result<List<Sku>> findAll();

}
