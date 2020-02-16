package ab.tjl.changgou.goods.controller;

import ab.tjl.changgou.goods.pojo.Brand;
import ab.tjl.changgou.goods.service.BrandService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author:TangJiLin
 * @Description:品牌控制层
 * @Date: Created in 2020/2/15 14:53
 * @Modified By:
 */
@RestController
@RequestMapping("/brand")
@CrossOrigin  //跨域：A域名访问B域名的数据
public class BrandController {

    @Autowired
    private BrandService brandService;

    /***
     * 分页搜索实现
     * @param brand
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) Brand brand, @PathVariable  int page, @PathVariable  int size){
        //执行搜索
        PageInfo<Brand> pageInfo = brandService.findPage(brand, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //分页查询
        PageInfo<Brand> pageInfo = brandService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param brand
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<Brand>> findList(@RequestBody(required = false) Brand brand){
        List<Brand> list = brandService.findList(brand);
        return new Result<List<Brand>>(true,StatusCode.OK,"查询成功",list);
    }

    /**
     * 根据id删除品牌
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable(value = "id") Integer id){
        brandService.delete(id);
        return new Result(true,StatusCode.OK,"删除品牌成功");
    }

    /**
     * 根据id修改品牌数据
     * @param id
     * @param brand
     * @return
     */
    @PutMapping(value = "{id}")
    public Result update(@PathVariable(value = "id") Integer id, @RequestBody Brand brand){
        brand.setId(id);
        brandService.update(brand);
        return new Result(true,StatusCode.OK,"修改品牌数据成功!");
    }

    /**
     * 增加品牌
     * @param brand
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Brand brand){
        brandService.add(brand);
        return new Result(true,StatusCode.OK,"增加品牌成功！");
    }

    /**
     * 根据id查询品牌
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public Result<Brand> findById(@PathVariable(value = "id") Integer id){
        Brand brand = brandService.findById(id);
        return new Result<Brand>(true, StatusCode.OK,"根据id查询品牌成功",brand);
    }

    /**
     * 查询所有品牌
     * @return
     */
    @GetMapping
    @ResponseBody
    public Result<List<Brand>> findAll() {
        List<Brand> brands = brandService.findAll();
        return new Result<List<Brand>>(true,StatusCode.OK,"查询品牌集合成功",brands);
    }
}
