package com.lazycece.sbac.mail.manager;

import com.lazycece.sbac.mail.entity.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author lazycece
 * @date 2019/5/21
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MailManagerTest {

    @Resource
    private MailManager mailManager;

    @Test
    public void testSendSimpleMessage() {
        Message message = Message.builder().to("").text("").build();
        mailManager.sendSimpleMessage(message);
    }

    @Test
    public void testSendPreparatorMimeMessage() {
        Message message = Message.builder()
                .to("")
                .text("").build();
        mailManager.sendPreparatorMimeMessage(message);
    }

    @Test
    public void sendBasicMimeMessage() {
        Message message = Message.builder()
                .to("")
                .text("").build();
        mailManager.sendBasicMimeMessage(message);
    }

    @Test
    public void sendAttachmentsMimeMessage() {
        Message message = Message.builder()
                .to("")
                .text("")
                .attachment("").build();
        mailManager.sendAttachmentsMimeMessage(message);
    }

    @Test
    public void sendInlineImageMimeMessage() {
        Message message = Message.builder()
                .to("")
                .text("")
                .inlineResource("").build();
        mailManager.sendInlineImageMimeMessage(message);
    }


}
