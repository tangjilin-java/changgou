package ab.tjl.changgou.search.dao;

import ab.tjl.changgou.search.pojo.SkuInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author:TangJiLin
 * @Description:
 * @Date: Created in 2020/2/19 16:06
 * @Modified By:
 */
@Repository
public interface SkuEsMapper extends ElasticsearchRepository<SkuInfo,Long> {
}
