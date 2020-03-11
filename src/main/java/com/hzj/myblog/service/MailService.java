package com.hzj.myblog.service;

import javax.mail.MessagingException;

/**
 * 发送邮件接口
 *
 * @author 何志坚
 */
public interface MailService {

    /**
     * 发送 html 邮件
     *
     * @param toEmail 发送邮箱地址
     * @param title   标题
     * @param content 内容
     */
    void sendHtmlMail(String toEmail, String title, String content) throws MessagingException;

}
