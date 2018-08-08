package com.github.exception;

/**
 * Created by chenjunlong on 2018/8/8.
 */
public interface ProcessCallable {

    Object call(String targetClass, String method, Object[] args, Object result, long processTimeMillis);
}
