package com.xupt.component;

public class BizException extends Exception {

    //无参构造方法
    public BizException(){

        super();
    }

    //有参的构造方法
    public BizException(String message){
        super(message);

    }

    // 用指定的详细信息和原因构造一个新的异常
    public BizException(String message, Throwable cause){

        super(message,cause);
    }

    //用指定原因构造一个新的异常
    public BizException(Throwable cause) {

        super(cause);
    }

}
