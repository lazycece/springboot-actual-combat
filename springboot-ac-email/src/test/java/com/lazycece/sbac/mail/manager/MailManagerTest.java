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
        Message message = Message.builder()
                .from("lazycece@163.com")
                .to("lazycece@qq.com")
                .subject("你好")
                .text("Hello, simple message ! ")
                .build();
        mailManager.sendSimpleMessage(message);
    }

    @Test
    public void testSendPreparatorMimeMessage() {
        Message message = Message.builder()
                .from("lazycece@163.com")
                .to("lazycece@qq.com")
                .subject("你好")
                .text("Hello, preparator mime message ! ")
                .build();
        mailManager.sendPreparatorMimeMessage(message);
    }

    @Test
    public void sendBasicMimeMessage() {
        Message message = Message.builder()
                .to("lazycece@qq.com")
                .from("lazycece@163.com")
                .subject("你好")
                .text("Hello, basic mime email ! ")
                .build();
        mailManager.sendBasicMimeMessage(message);
    }

    @Test
    public void sendAttachmentsMimeMessage() {
        Message message = Message.builder()
                .to("lazycece@qq.com")
                .from("lazycece@163.com")
                .subject("你好")
                .text("Hello, attachment mime email ! ")
                .attachment("C:\\Users\\CC\\Downloads\\CigHElziSRiACkYtAAOKkkCI_Fs222.wav")
                .build();
        mailManager.sendAttachmentsMimeMessage(message);
    }

    @Test
    public void sendInlineImageMimeMessage() {
        Message message = Message.builder()
                .to("lazycece@qq.com")
                .from("lazycece@163.com")
                .subject("你好")
                .text("Hello, inline image mime email ! ")
                .inlineResource("F:\\lazycc\\bicycle-minimalistic-art-1.jpg")
                .build();
        mailManager.sendInlineImageMimeMessage(message);
    }
}
