package com.common.mailservicemanage.service;


/**
 * @author spring.yuan
 * @version 1.0
 */
public interface EmailService {

    /**
     * @param to      收件人地址，数组
     * @param subject 邮件主题
     * @param content 邮件内容
     * @desc 发送简单邮件
     */
    void sendSimpleEmail(String[] to, String subject, String content);


    /**
     * @param to      收件人地址，数组
     * @param subject 邮件主题
     * @param content 邮件内容
     * @desc 发送html格式邮件
     */
    void sendHtmlEmail(String[] to, String subject, String content);


    /**
     * @param to       收件人地址，数组
     * @param subject  邮件主题
     * @param content  邮件内容
     * @param filePath 附件地址
     * @desc 发送带附件的邮件
     */
    void sendAttachmentsEmail(String[] to, String subject, String content, String filePath);


    /**
     * @param to      收件人地址，数组
     * @param subject 邮件主题
     * @param content 邮件内容
     * @param rscPath
     * @param rscId
     * @desc 发送带静态资源的邮件
     */
    void sendInlineResourceEmail(String[] to, String subject, String content, String rscPath, String rscId);
}
