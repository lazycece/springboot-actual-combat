package com.lazycece.sbac.mail.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lazycece
 * @date 2019/5/21
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    /**
     * 收件人
     */
    private String to;
    /**
     * 发件人
     */
    private String from;
    /**
     * 邮件主题
     */
    private String subject;
    /**
     * 邮件内容
     */
    private String text;
    /**
     * 附件
     */
    private String attachment;
    /**
     * 嵌入资源
     */
    private String inlineResource;
}
