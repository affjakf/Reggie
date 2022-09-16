package com.yzstu.comon;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 该类用于自定义元数据对象处理器
   createTime;
   updateTime;
   createUser;
   updateUser;
 */
@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {
    //插入数据的时候触发
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("公共字段自动填充[insert]");
        metaObject.setValue("createTime", LocalDateTime.now());
        metaObject.setValue("updateTime", LocalDateTime.now());
        //利用工具类中提供的方法 将id拿出 并且设置到对应的位置
        metaObject.setValue("createUser",BaseContext.getCurrentId());

        metaObject.setValue("updateUser", BaseContext.getCurrentId());
        log.info(metaObject.toString());
    }

    //修改的时候触发
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("公共字段自动填充[update]...");
        log.info(metaObject.toString());

        long id = Thread.currentThread().getId();
        log.info("线程id为：{}",id);

        metaObject.setValue("updateTime",LocalDateTime.now());
        metaObject.setValue("updateUser",BaseContext.getCurrentId());

    }
}
