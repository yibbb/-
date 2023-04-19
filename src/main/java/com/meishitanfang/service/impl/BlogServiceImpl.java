package com.meishitanfang.service.impl;

import com.meishitanfang.entity.Blog;
import com.meishitanfang.mapper.BlogMapper;
import com.meishitanfang.service.IBlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements IBlogService {

}
