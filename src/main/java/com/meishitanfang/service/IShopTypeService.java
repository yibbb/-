package com.meishitanfang.service;

import com.meishitanfang.dto.Result;
import com.meishitanfang.entity.ShopType;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 */
public interface IShopTypeService extends IService<ShopType> {

    Result getlist();
}
