package com.example.demo.vo;

/**
 * @Author: mrt.
 * @Description:
 * @Date:Created in 2018/1/24 18:33.
 * @Modified By:
 */
public class ResponseResultVo implements ResponseVo {

    //操作是否成功
    boolean success = SUCCESS;

    //操作代码
    int code = SUCCESS_CODE;

    //提示信息
    String message;

    public ResponseResultVo(ResultCodeVo resultCode){
        this.success = resultCode.success();
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    public static ResponseResultVo SUCCESS(){
        return new ResponseResultVo(CommonCodeVo.SUCCESS);
    }
    public static ResponseResultVo FAIL(){
        return new ResponseResultVo(CommonCodeVo.FAIL);
    }

}
