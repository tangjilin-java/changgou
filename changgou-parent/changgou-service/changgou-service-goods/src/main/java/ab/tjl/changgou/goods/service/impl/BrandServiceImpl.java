package ab.tjl.changgou.goods.service.impl;

import ab.tjl.changgou.goods.dao.BrandMapper;
import ab.tjl.changgou.goods.pojo.Brand;
import ab.tjl.changgou.goods.service.BrandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Author:TangJiLin
 * @Description:品牌业务层接口实现类
 * @Date: Created in 2020/2/15 14:52
 * @Modified By:
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    /**
     * 条件+分页查询
     * @param brand 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Brand> findPage(Brand brand, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(brand);
        //执行搜索
        return new PageInfo<Brand>(brandMapper.selectByExample(example));
    }

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Brand> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Brand>(brandMapper.selectAll());
    }

    /**
     * 多条件查询品牌
     * @param brand
     * @return
     */
    @Override
    public List<Brand> findList(Brand brand) {
        Example example = createExample(brand);
        return brandMapper.selectByExample(example);
    }

    /**
     * 构建查询对象
     * @param brand
     * @return
     */
    public Example createExample(Brand brand){
        Example example=new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        if(brand!=null){
            // 品牌名称
            if(!StringUtils.isEmpty(brand.getName())){
                criteria.andLike("name","%"+brand.getName()+"%");
            }
            // 品牌图片地址
            if(!StringUtils.isEmpty(brand.getImage())){
                criteria.andLike("image","%"+brand.getImage()+"%");
            }
            // 品牌的首字母
            if(!StringUtils.isEmpty(brand.getLetter())){
                criteria.andLike("letter","%"+brand.getLetter()+"%");
            }
            // 品牌id
            if(!StringUtils.isEmpty(brand.getLetter())){
                criteria.andEqualTo("id",brand.getId());
            }
            // 排序
            if(!StringUtils.isEmpty(brand.getSeq())){
                criteria.andEqualTo("seq",brand.getSeq());
            }
        }
        return example;
    }

    /**
     * 根据id删除品牌
     * @param id
     */
    @Override
    public void delete(Integer id) {
        brandMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据id修改品牌数据
     * @param brand
     */
    @Override
    public void update(Brand brand) {
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    /**
     * 增加品牌
     * @param brand
     */
    @Override
    public void add(Brand brand) {
        brandMapper.insertSelective(brand);
    }

    /**
     * 通过id查询品牌
     * @param id
     * @return
     */
    @Override
    public Brand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有品牌
     * @return
     */
    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }
}
