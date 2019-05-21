package com.lazycece.sbac.mail.manager;

import com.lazycece.sbac.mail.entity.Message;

/**
 * @author lazycece
 * @date 2019/5/21
 */
public interface MailManager {

    void sendSimpleMessage(Message message);

    void sendPreparatorMimeMessage(Message message);

    void sendBasicMimeMessage(Message message);

    void sendAttachmentsMimeMessage(Message message);

    void sendInlineImageMimeMessage(Message message);
}
