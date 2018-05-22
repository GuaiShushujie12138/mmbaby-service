package com.mmbaby.product.bizservice;

import com.mmbaby.base.util.PageUtil;
import com.mmbaby.product.dto.domain.ProductDTO;
import com.mmbaby.product.dto.query.ProductQueryDTO;

import java.util.List;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/15 at 19:13
 */
public interface IProductQueryBizService {

    /**
     * 根据商品id查询商品详情
     *
     * @param productId
     * @return
     */
    ProductDTO queryProductById(Integer productId);

    /**
     * 多重条件查询商品list
     *
     * @param productQueryDTO
     * @return
     */
    List<ProductDTO> queryProductList(ProductQueryDTO productQueryDTO, PageUtil page);

    /**
     * 根据关键字搜索商品
     * @param pageUtil
     * @return
     */
    List<ProductDTO> queryByKeyWord(PageUtil pageUtil);
}
