package com.lazycece.sbac.exception.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lazycece
 * @date 2019/02/23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseData {

    private Integer code;
    private String message;
    private Object data;
}
