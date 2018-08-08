package com.github.exception;

/**
 * Created by chenjunlong on 2018/8/8.
 */
public interface ExceptionCallable {

    Object call(Exception e, String targetClass, String method, Object[] args);
}
