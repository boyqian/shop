package com.boyqian.shop.advice;

import com.boyqian.shop.exception.ShopAppException;
import com.boyqian.shop.vo.CommonResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author boyqian
 * @time 2020/03/12 09:01
 * @Description 全局异常处理的增强
 * */
@RestControllerAdvice
public class GlobalExceptionAdvice{

    // 系统抛出异常统一响应  可自定义 权限 功能等等的实现
    @ExceptionHandler(value = ShopAppException.class)  // 对指定异常ShopAppException 进行拦截
    public CommonResponse<String> handlerShopAppException(HttpServletRequest request, ShopAppException saException){
        CommonResponse<String> response=new CommonResponse<>(-1,"系统错误");
        response.setData(saException.getMessage());
        return response;
    }
}
