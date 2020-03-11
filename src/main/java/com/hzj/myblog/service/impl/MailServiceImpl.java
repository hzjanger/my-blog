package com.hzj.myblog.service.impl;

import com.hzj.myblog.service.MailService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * 邮件发送接口实现类
 *
 * @author 何志坚
 */
@Service
public class MailServiceImpl implements MailService {

    private Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);

    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * 发件人
     */
    @Value("${spring.mail.username}")
    private String from;

    /**
     * 发送 html 邮件
     *
     * @param toEmail 发送邮箱地址
     * @param title   标题
     * @param content 内容
     * @throws MessagingException 邮件异常信息
     */
    @Override
    public void sendHtmlMail(String toEmail, String title, String content) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(this.from);
        helper.setTo(toEmail);
        helper.setSubject(title);
        helper.setText(content, true);
        javaMailSender.send(message);
    }
}
