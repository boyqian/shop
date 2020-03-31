package com.boyqian.shop.exception;

/**
 * @author boyqian
 * @time 2020/03/12 09:22
 * @Description 可自定义所有异常，或者各种异常
 * */
public class ShopAppException extends Exception{

    public ShopAppException(String msg){
        super(msg);
    }
}
