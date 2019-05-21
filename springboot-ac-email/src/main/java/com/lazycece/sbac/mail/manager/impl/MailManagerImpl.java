package com.lazycece.sbac.mail.manager.impl;

import com.lazycece.sbac.mail.entity.Message;
import com.lazycece.sbac.mail.manager.MailManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.io.File;


/**
 * @author lazycece
 * @date 2019/5/21
 */
@Component
@Slf4j
public class MailManagerImpl implements MailManager {

    private MailSender mailSender;
    private JavaMailSender javaMailSender;

    @Autowired
    public MailManagerImpl(MailSender mailSender, JavaMailSender javaMailSender) {
        this.mailSender = mailSender;
        this.javaMailSender = javaMailSender;
    }


    @Override
    public void sendSimpleMessage(Message message) {
        SimpleMailMessage msg = new SimpleMailMessage();
//        msg.setFrom();
//        msg.setSubject();
        msg.setTo(message.getTo());
        msg.setText(message.getText());
        mailSender.send(msg);
    }

    @Override
    public void sendPreparatorMimeMessage(Message message) {
        MimeMessagePreparator preparator = mimeMessage -> {
            mimeMessage.setRecipients(javax.mail.Message.RecipientType.TO, message.getTo());
//                mimeMessage.setFrom("");
            mimeMessage.setText(message.getText());
        };
        javaMailSender.send(preparator);
    }

    @Override
    public void sendBasicMimeMessage(Message message) {
        MimeMailMessage mimeMailMessage = new MimeMailMessage(javaMailSender.createMimeMessage());
        try {
            MimeMessageHelper helper = mimeMailMessage.getMimeMessageHelper();
            helper.setTo(message.getTo());
            helper.setText(message.getText());
        } catch (MessagingException e) {
            log.error("build message error");
        }
        javaMailSender.send(mimeMailMessage.getMimeMessage());

    }

    @Override
    public void sendAttachmentsMimeMessage(Message message) {
        MimeMailMessage mimeMailMessage = new MimeMailMessage(javaMailSender.createMimeMessage());
        try {
            MimeMessageHelper helper = mimeMailMessage.getMimeMessageHelper();
            helper.setTo(message.getTo());
            helper.setText(message.getText());
            FileSystemResource file = new FileSystemResource(new File(message.getAttachment()));
            helper.addAttachment("attachment", file);
        } catch (MessagingException e) {
            log.error("build message error");
        }
        javaMailSender.send(mimeMailMessage.getMimeMessage());
    }

    @Override
    public void sendInlineImageMimeMessage(Message message) {
        MimeMailMessage mimeMailMessage = new MimeMailMessage(javaMailSender.createMimeMessage());
        try {
            MimeMessageHelper helper = mimeMailMessage.getMimeMessageHelper();
            helper.setTo(message.getTo());
            String html = "<html><body><img src='cid:inline-resource'></body></html>";
            helper.setText(message.getText(), html);
            FileSystemResource resource = new FileSystemResource(new File(message.getInlineResource()));
            helper.addAttachment("inline-resource", resource);
        } catch (MessagingException e) {
            log.error("build message error");
        }
        javaMailSender.send(mimeMailMessage.getMimeMessage());
    }
}
