package com.example.demo.vo;


/**
 * @Author: mrt.
 * @Description:
 * @Date:Created in 2018/1/24 18:33.
 * @Modified By:
 */

public enum CommonCodeVo implements ResultCodeVo{

    SUCCESS(true,10000,"操作成功！"),//返回CommonCode实例
    FAIL(false,11111,"操作失败！"),
    UNAUTHENTICATED(false,10001,"此操作需要登陆系统！"),
    UNAUTHORISE(false,10002,"权限不足，无权操作！"),
    //非法参数
    INVLIDATE(false,10003,"非法参数！"),
    SERVER_ERROR(false,99999,"抱歉，系统繁忙，请稍后重试！");
//    private static ImmutableMap<Integer, CommonCode> codes ;
    //操作是否成功
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;
    private CommonCodeVo(boolean success,int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean success() {
        return success;
    }
    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }


}
