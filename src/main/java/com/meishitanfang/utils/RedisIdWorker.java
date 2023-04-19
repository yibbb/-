package com.meishitanfang.utils;


import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

//实现全局唯一id
@Component
public class RedisIdWorker {
    /**
     * 开始的时间戳
     */
    private static final long BEGIN_TIMETAMP=1640995200L;
    /**
     * 序列号的位置
     */
    private static final int COUNT_BITS=32;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public RedisIdWorker(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public long nextId(String KeyPrefix){
        //生成时间戳
        LocalDateTime now = LocalDateTime.now();
        long nowSecond=now.toEpochSecond(ZoneOffset.UTC);
        long timestamp=nowSecond-BEGIN_TIMETAMP;
        //生成序列号
            //获取当前的日期，精确到天
            String date=now.format(DateTimeFormatter.ofPattern("yyyy:MM:dd"));
            //自增长
        long count=stringRedisTemplate.opsForValue().increment("icr:"+KeyPrefix+":"+date);
        //接受并返回
        return timestamp<<COUNT_BITS | count;//或运算
    }

}
