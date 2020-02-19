package ab.tjl.changgou.search.controller;

import ab.tjl.changgou.search.service.SkuService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

/**
 * @Author:TangJiLin
 * @Description:
 * @Date: Created in 2020/2/19 16:12
 * @Modified By:
 */
@RestController
@CrossOrigin
@RequestMapping("/search")
public class SkuController {

    @Autowired
    private SkuService skuService;

    /**
     * 搜索功能
     * @param searchMap
     * @return
     */
    @GetMapping
    @ResponseBody
    public Map search(@RequestParam Map<String,String> searchMap){
        //特殊符号处理
        this.handleSearchMap(searchMap);
        Map searchResult = skuService.search(searchMap);
        return searchResult;
    }

    /**
     * 导入数据
     * @return
     */
    @GetMapping("/import")
    public Result importData(){
        skuService.importData();
        return new Result(true, StatusCode.OK,"导入数据到索引库成功！");
    }


    /**
     * 特殊符号处理
     * @param searchMap
     */
    private void handleSearchMap(Map<String, String> searchMap) {
        Set<Map.Entry<String, String>> entries = searchMap.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            if (entry.getKey().startsWith("spec_")){
                searchMap.put(entry.getKey(),entry.getValue().replace("+","%2B"));
            }
        }
    }
}
