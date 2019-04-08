package com.people.management.sendEmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/email")
public class testSendEmail {

    @Autowired
    private SendMailUtil sendMailUtil;

    @RequestMapping(value = "/sendEmail")
    @ResponseBody
    public void sendEmail(){

        sendMailUtil.sendMail("希望","测试","1790979952@qq.com");
    }
}
