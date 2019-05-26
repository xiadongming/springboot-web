package com.example.demo.vo;



public class QueryResponseResultVo<T> extends ResponseResultVo {

    QueryResultVo<T> queryResult;

    public QueryResponseResultVo(ResultCodeVo resultCode,QueryResultVo<T> queryResult){
        super(resultCode);
       this.queryResult = queryResult;
    }

}
