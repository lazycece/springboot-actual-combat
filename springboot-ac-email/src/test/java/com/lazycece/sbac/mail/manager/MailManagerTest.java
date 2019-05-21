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

    private Message.MessageBuilder commonMail() {
        return Message.builder()
                .from("lazycece@gmail.com")
                .to("lazycece@gmail.com")
                .subject("你好");
    }

    @Test
    public void testSendSimpleMessage() {
        Message message = commonMail()
                .text("Hello, simple message ! ")
                .build();
        mailManager.sendSimpleMessage(message);
    }

    @Test
    public void testSendPreparatorMimeMessage() {
        Message message = commonMail()
                .text("Hello, preparator mime message ! ")
                .build();
        mailManager.sendPreparatorMimeMessage(message);
    }

    @Test
    public void sendBasicMimeMessage() {
        Message message = commonMail()
                .text("Hello, basic mime email ! ")
                .build();
        mailManager.sendBasicMimeMessage(message);
    }

    @Test
    public void sendAttachmentsMimeMessage() {
        Message message = commonMail()
                .text("Hello, attachment mime email ! ")
                .attachment("/home/lazycece/下载/rabbitmq-cluster-framework.png")
                .build();
        mailManager.sendAttachmentsMimeMessage(message);
    }

    @Test
    public void sendInlineImageMimeMessage() {
        Message message = commonMail()
                .text("Hello, inline image mime email ! ")
                .inlineResource("/home/lazycece/下载/rabbitmq-cluster-framework.png")
                .build();
        mailManager.sendInlineImageMimeMessage(message);
    }
}
