package ab.tjl.changgou.goods.service;

import ab.tjl.changgou.goods.pojo.Brand;
import com.github.pagehelper.PageInfo;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * @Author:TangJiLin
 * @Description:品牌业务层接口
 * @Date: Created in 2020/2/15 14:52
 * @Modified By:
 */
public interface BrandService {

    /***
     * 多条件分页查询
     * @param brand
     * @param page
     * @param size
     * @return
     */
    PageInfo<Brand> findPage(Brand brand, int page, int size);

    /***
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Brand> findPage(int page,int size);

    /***
     * 多条件搜索品牌方法
     * @param brand
     * @return
     */
    List<Brand> findList(Brand brand);

    /**
     * 根据id删除品牌
     * @param id
     */
    void delete(Integer id);

    /**
     * 根据id修改品牌数据
     * @param brand
     */
    void update(Brand brand);

    /**
     * 增加品牌
     * @param brand
     */
    void add(Brand brand);

    /**
     * 通过id查询品牌
     * @param id
     * @return
     */
    Brand findById(Integer id);

    /**
     * 查询所有品牌
     * @return
     */
    List<Brand> findAll();
}
