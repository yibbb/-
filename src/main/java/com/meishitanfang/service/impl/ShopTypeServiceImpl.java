package com.meishitanfang.service.impl;

import cn.hutool.json.JSONUtil;
import com.meishitanfang.dto.Result;
import com.meishitanfang.entity.ShopType;
import com.meishitanfang.mapper.ShopTypeMapper;
import com.meishitanfang.service.IShopTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 */
@Service
public class ShopTypeServiceImpl extends ServiceImpl<ShopTypeMapper, ShopType> implements IShopTypeService {
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public Result getlist() {
        //在redis中查找
        String cacheshoptype = stringRedisTemplate.opsForValue().get("cache:shoptypelist:");
        //转化为json对象集合
        List<ShopType> shopTypes= JSONUtil.toList(cacheshoptype,ShopType.class);
        //存在直接返回
        if (shopTypes.size()!=0){
            return Result.ok(shopTypes);
        }
        //不存在查询数据库
        List<ShopType> shopTypeList = query().orderByAsc("sort").list();
        //数据库不存在，返回错误信息
        if(shopTypeList.size()==0){
            return Result.fail("查询错误！");
        }
        //数据库存在，写入redis并返回
        stringRedisTemplate.opsForValue().set("cache:shoptypelist:",JSONUtil.toJsonStr(shopTypeList));
        return Result.ok(shopTypeList);
    }
}
