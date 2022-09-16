package com.yzstu.controller;

import com.yzstu.comon.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

/**
 * 文件上传下载
 */
@RestController
@RequestMapping("/common")
@Slf4j
public class CommonController {

    //获取yml文件的上传路径
    @Value("${reggie.path}")
    private String path;

    @PostMapping("/upload")
    public R<String> upload(MultipartFile file) {
        //file为临时文件  需要转存到具体的目录 否则本次请求完成后会自动摧毁
        //MultipartFile file 形参名必须和请求的名一致  否则会null
        log.info(file.toString());

        //原始文件名
        String originalFilename = file.getOriginalFilename();
        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
    //使用uuid重新生成文件名，防止文件名称造成文件覆盖
        String uuid = UUID.randomUUID().toString() + substring;
        //判断目录是否存在
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        try {
            //设置上传的文件路径 以及文件名
            file.transferTo(new File(path + uuid));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.success(uuid);
    }

    @GetMapping("/download")
    public void download(String name, HttpServletResponse response) {

        try {
            //输入流 通过输入流读取文件内容
            FileInputStream fileInputStream = new FileInputStream(new File(path + name));
            //输出流 通过输出流将文件写会浏览器 在浏览器展示图片
            ServletOutputStream outputStream = response.getOutputStream();
            response.setContentType("image/jpeg");
            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = fileInputStream.read(bytes)) != -1) {
                outputStream.write(bytes,0,len);
                outputStream.flush();
            }
            outputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
