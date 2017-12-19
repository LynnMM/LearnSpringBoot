package org.lynn.springboot.girl.exception;

import org.lynn.springboot.girl.enums.ResultEnum;

public class PersonException extends RuntimeException {
    private Integer code;

    public PersonException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
