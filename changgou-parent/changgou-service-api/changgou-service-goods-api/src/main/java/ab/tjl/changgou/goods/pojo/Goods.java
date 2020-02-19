package ab.tjl.changgou.goods.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @Author:TangJiLin
 * @Description:商品信息model
 * @Date: Created in 2020/2/18 14:44
 * @Modified By:
 *
 * 商品信息组合对象
 * List<Sku>
 *     spu
 */
public class Goods implements Serializable {

    private Spu spu;
    private List<Sku> skuList;

    public Spu getSpu() {
        return spu;
    }

    public void setSpu(Spu spu) {
        this.spu = spu;
    }

    public List<Sku> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<Sku> skuList) {
        this.skuList = skuList;
    }
}
