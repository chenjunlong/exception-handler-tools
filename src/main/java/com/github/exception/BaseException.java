package com.github.exception;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by chenjunlong on 2018/8/7.
 */
public abstract class BaseException extends RuntimeException {

    private String result;

    private String msg;

    private String process;

    private Map<String, Object> params = new LinkedHashMap<>();

    public BaseException(String result) {
        super(result);
        this.result = result;
    }

    public BaseException(String result, String msg) {
        super(msg);
        this.result = result;
        this.msg = msg;
    }

    public BaseException(String result, String msg, String process) {
        super(msg);
        this.result = result;
        this.msg = msg;
        this.process = process;
    }

    public String getResult() {
        return result;
    }

    public String getMsg() {
        return msg;
    }

    public String getProcess() {
        return process;
    }

    /**
     * 设置异常参数
     *
     * @param key
     * @param value
     * @return
     */
    public BaseException setParams(final String key, final Object value) {
        params.put(key, value);
        return this;
    }

    /**
     * 异常快照
     *
     * @return
     */
    public String getExceptionSnapshotInfo() {
        Map<String, Object> errorInfo = new LinkedHashMap<>();
        errorInfo.put("result", result);
        if (null != msg) {
            errorInfo.put("msg", msg);
        }
        if (null != process) {
            errorInfo.put("process", process);
        }
        errorInfo.put("snapshot", params.toString());
        return errorInfo.toString();
    }
}
