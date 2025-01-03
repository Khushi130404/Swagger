package com.example.my_swag.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailRepo
{
    @Autowired
    public JavaMailSender jms;

    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        // message.setFrom("vikaspatni1984@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        jms.send(message);
    }

}
