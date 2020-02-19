package ab.tjl.changgou.search.service;

import java.util.Map;

/**
 * @Author:TangJiLin
 * @Description:sku接口
 * @Date: Created in 2020/2/19 16:02
 * @Modified By:
 */
public interface SkuService {

    /**
     * 条件搜索
     * @param searchMap
     * @return
     */
    Map<String,Object> search(Map<String,String> searchMap);
    /**
     * 导入数据到索引库中
     */
    void importData();
}
