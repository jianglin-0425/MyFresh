package com.jl.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: testspring
 * @description:
 * @author: LIN
 * @create: 2021~05~04 20:54
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonModel implements Serializable {
    private Integer code;
    private String msg;
    private Object obj;
    private String url;
}
