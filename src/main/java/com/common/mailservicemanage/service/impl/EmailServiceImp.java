package com.common.mailservicemanage.service.impl;

import com.common.mailservicemanage.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author DC Yuan
 * @version 1.0
 */
@Slf4j
@Component
public class EmailServiceImp implements EmailService {

    @Resource
    private JavaMailSender mailSender;

    @Value("${mail.fromMail.addr}")
    private String from;

    @Override
    public void sendSimpleEmail(String[] to, String subject, String content) {
        // 创建简单邮件消息
        SimpleMailMessage message = new SimpleMailMessage();
        // 设置发送人
        message.setFrom(from);
        // 设置收件人
        message.setTo(to);

        // 设置主题
        message.setSubject(subject);
        // 设置内容
        message.setText(content);
        try {
            // 执行发送邮件
            mailSender.send(message);
            log.info("简单邮件已经发送。");
        } catch (Exception e) {
            log.error("发送简单邮件时发生异常:{}", e);
        }
    }


    @Override
    public void sendHtmlEmail(String[] to, String subject, String content) {
        // 创建一个MINE消息
        MimeMessage message = mailSender.createMimeMessage();
        try {
            // true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            mailSender.send(message);
            log.info("html邮件发送成功");
        } catch (MessagingException e) {
            log.error("发送html邮件时发生异常:{}", e);
        }
    }


    @Override
    public void sendAttachmentsEmail(String[] to, String subject, String content, String filePath) {
        // 创建一个MINE消息
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);

            // true表示这个邮件是有附件的
            helper.setText(content, true);

            // 创建文件系统资源
            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            // 添加附件
            helper.addAttachment(fileName, file);

            mailSender.send(message);
            log.info("带附件的邮件已经发送。");
        } catch (MessagingException e) {
            log.error("发送带附件的邮件时发生异常:{}", e);
        }
    }


    @Override
    public void sendInlineResourceEmail(String[] to, String subject, String content, String rscPath, String rscId) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            FileSystemResource res = new FileSystemResource(new File(rscPath));

            // 添加内联资源，一个id对应一个资源，最终通过id来找到该资源
            // 添加多个图片可以使用多条 <img src='cid:" + rscId + "' > 和 helper.addInline(rscId, res)来实现
            helper.addInline(rscId, res);
            mailSender.send(message);
            log.info("嵌入静态资源的邮件已经发送。");
        } catch (MessagingException e) {
            log.error("发送嵌入静态资源的邮件时发生异常:{}", e);
        }
    }
}
