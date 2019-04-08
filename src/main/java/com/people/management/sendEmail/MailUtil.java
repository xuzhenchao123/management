package com.people.management.sendEmail;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
//@RequestMapping("/mail")
public class MailUtil {
//        @Autowired
//        JavaMailSender mailSender;
       // @Value("${spring.mail.username}")  //发送人的邮箱  比如155156641XX@163.com
    private String from;

        @ResponseBody
        @RequestMapping("/send")
        public Object sendEmail() {
            try {
//                final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
//                final MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
//                message.setFrom(from);
//                message.setTo("2514442973@qq.com");
//                message.setSubject("测试邮件主题");
//                message.setText("测试邮件内容");
//                this.mailSender.send(mimeMessage);

                return "sucesss";
            } catch (Exception ex) {
                ex.printStackTrace();
                return "error";
            }
        }
}
