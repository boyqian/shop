package com.boyqian.shop.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author boyqian
 * @time 2020/03/12 08:53
 * @Description 统一响应对象定义
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> implements Serializable {

    // 返回的状态码
    private Integer code;
    // 返回的消息
    private String msg;
    // 返回的数据
    private T data;

    public CommonResponse(Integer code, String msg){
        this.code=code;
        this.msg=msg;
    }
}
