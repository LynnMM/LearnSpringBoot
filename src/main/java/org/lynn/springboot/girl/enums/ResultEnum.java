package org.lynn.springboot.girl.enums;

public enum ResultEnum {
    UNKNOWN_ERROR(-1, "Unknow Error"),
    SUCCESS(0, "Success"),
    DATA_ERROR(1, "Data Error"),
    PRIMARY_SCHOOL(100, "You are at primary school"),
    MIDDLE_SCHOOL(101, "You are at Middle school"),
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
