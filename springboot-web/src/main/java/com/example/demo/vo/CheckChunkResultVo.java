package com.example.demo.vo;


/**
 * Created by admin on 2018/3/5.
 */

public class CheckChunkResultVo extends ResponseResultVo{

    public CheckChunkResultVo(ResultCodeVo resultCode, boolean fileExist) {
        super(resultCode);
        this.fileExist = fileExist;
    }
    boolean fileExist;
}
