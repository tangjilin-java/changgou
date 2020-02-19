package ab.tjl.changgou.goods.dao;
import ab.tjl.changgou.goods.pojo.Brand;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Brand的Dao
 * @Date 2019/6/14 0:12
 *****/
public interface BrandMapper extends Mapper<Brand> {
    /**
     * 根据分类id查询品牌
     * @param categoryId
     * @return
     */
    @Select("select tb.* from tb_brand tb,tb_category_brand tcb where tb.id=tcb.brand_id and tcb.category_id=#{categoryid}")
    List<Brand> findByCategory(Integer categoryId);
}
