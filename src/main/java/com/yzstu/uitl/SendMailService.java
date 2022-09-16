package com.yzstu.uitl;

import com.yzstu.comon.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

/**
 *
 */
@Component
public class SendMailService {
    @Autowired
    private JavaMailSender javaMailSender;
    /*发送邮件基础四件套：
     * 发件人
     * 收件人
     * 邮件标题
     * 邮件内容*/
    private String from = "18324185782@163.com";
    //private String to = "1341251795@qq.com";
    private String subject = "验证码";
    //private String text = null;

    public void sendmail(String to, String text) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            //第二个参数为 是否允许发附件
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            //第二个参数为是否允许识别（解析）为html
            mimeMessageHelper.setText(text);
            //发送邮件
            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            System.out.println(e);
            throw new CustomException("邮件发送失败 请重试");
        }
    }
}
