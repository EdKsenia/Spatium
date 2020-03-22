package ru.itis.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String userName;

    @Override
    public void sendMail(String subject, String text, String email) {
        MimeMessagePreparator messagePreparator = message -> {
//            message.setContent(text, "text/html");
            MimeMessageHelper messageHelper = new MimeMessageHelper(message);
            messageHelper.setFrom(userName);
            messageHelper.setTo(email);
            messageHelper.setSubject(subject);
            messageHelper.setText(text, true);
        };

        javaMailSender.send(messagePreparator);
    }
}
