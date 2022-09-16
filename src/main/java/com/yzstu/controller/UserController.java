package com.yzstu.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yzstu.comon.R;
import com.yzstu.domain.User;
import com.yzstu.service.UserService;
import com.yzstu.uitl.SendMailService;
import com.yzstu.uitl.ValidateCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 *
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private SendMailService sendMailService;

    @PostMapping("/sendMsg")
    public R<String> sendMsg(@RequestBody User user, HttpSession httpSession) {
        //获取邮箱  ps:这里的phone为 mail邮箱地址
        String phone = user.getPhone();
        if (StringUtils.isNotEmpty(phone)) {
            //生成验证码
            String text = ValidateCodeUtils.generateValidateCode4String(4);
            System.out.println(text);
            //发送邮件
            //sendMailService.sendmail(phone, text);
            //保存验证码     Session
            httpSession.setAttribute(phone, text);
            return R.error("邮件发送成功");
        }
        return R.error("邮件发送失败");
    }


        //移动端登录
    @PostMapping("/login")
    public R<User> login(@RequestBody Map map, HttpSession httpSession) {
        log.info(map.toString());
        //获取手机号
        String phone = map.get("phone").toString();
        //获取验证码
        String code = map.get("code").toString();
        //从session中获取验证码
        Object text = httpSession.getAttribute(phone);
        //进行验证码的比对
        if (text.equals(code)&&text!=null){
            //如果比对成功 ，登录成功
            //判断手机号是否为新用户 新用户自动注册
            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(User::getPhone,phone);
            User one = userService.getOne(queryWrapper);
            if (one == null) {
                //没有查到用户
                User user = new User();
                user.setPhone(phone);
                user.setStatus(1);
                userService.save(user);
            }
            httpSession.setAttribute("user", one.getId());
            return R.success(one);
        }
        return R.error("登录失败");
    }
}
