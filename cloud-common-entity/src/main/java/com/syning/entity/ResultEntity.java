package com.syning.entity;




/**
 *  整个项目中，Ajax请求返回的结果，统一封装成 ResultEntity 对象（将来也可以用于分布式架构各个模块间调用时返回统一类型）
 */
public class ResultEntity <T> {

    public static final String SUCCESS = "SUCCESS";
    public static final String FAILED = "FAILED";

    // 用来封装当前请求处理的结果是成功还是失败
    private String result;

    // 请求失败时，返回的错误消息
    private String message;

    // 返回的数据
    private T data;


    /**
     *  请求处理成功且不需要返回数据时，使用此工具方法
     */
    public static <Type> ResultEntity<Type> successWithoutData() {
        return new ResultEntity<>(SUCCESS, null, null);
    }

    /**
     *  请求处理成功且需要返回数据时，使用此工具方法
     * @param data 处理成功返回的数据
     */
    public static <Type> ResultEntity<Type> successWithData(Type data) {
        return new ResultEntity<>(SUCCESS, null, data);
    }

    /**
     *  请求处理成功，并且返回成功消息和数据
     * @param data 处理成功返回的数据
     */
    public static <Type> ResultEntity<Type> successWithData(String message, Type data) {
        return new ResultEntity<>(SUCCESS, message, data);
    }


    /**
     *  请求处理失败后，使用的工具方法
     * @param message 处理失败的错误消息
     */
    public static <Type> ResultEntity<Type> failed(String message) {
        return new ResultEntity<>(FAILED, message, null);
    }


    public ResultEntity() {}

    @Override
    public String toString() {
        return "ResultEntity{" +
                "result='" + result + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public ResultEntity(String result, String message, T data) {
        this.result = result;
        this.message = message;
        this.data = data;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
