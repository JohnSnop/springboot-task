package com.wf.task;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@SpringBootTest
class SpringbootTaskApplicationTests {

    @Autowired
    private JavaMailSenderImpl sender;

    @Value("${spring.mail.username}")
    private String from;

    @Test
    void contextLoads() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("通知-今晚吃鸡");
        simpleMailMessage.setText("今晚吃鸡");
        simpleMailMessage.setTo("1766441627@qq.com");
        // simpleMailMessage.setFrom(from);
        sender.send(simpleMailMessage);
    }

    @Test
    public void test() throws MessagingException {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setSubject("通知-今晚吃鸡");
        helper.setText("今晚吃鸡");
        helper.setTo("1766441627@qq.com");

        // helper.addAttachment();
        // helper.addAttachment();
        sender.send(message);
    }
}
