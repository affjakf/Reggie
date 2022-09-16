package com.yzstu.comon;

/**
 *基于封装ThreadLocal的工具类
 * 用户保存和获取当前登录用户id
 */
public class BaseContext {
    private  static  ThreadLocal<Long> threadLocal=new ThreadLocal<>();

    //封装threadlocal的set方法
    public static  void setCurrentId(Long id){
        threadLocal.set(id);
    }

    public static  Long getCurrentId(){
        return threadLocal.get();

    }
}
