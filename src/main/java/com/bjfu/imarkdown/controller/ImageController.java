package com.bjfu.imarkdown.controller;

import com.alibaba.fastjson.JSONObject;
import com.bjfu.imarkdown.dto.FileInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Date;

@Controller
@RequestMapping(value = "/image")
public class ImageController {

    @Value("${img.location}")
    private String folder;

    @PostMapping
    @ResponseBody
    public FileInfo uploadImg(HttpServletRequest request, HttpServletResponse response,
                                @RequestParam(value = "editormd-image-file", required = false) MultipartFile file) throws Exception{
        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        String newFileName = new Date().getTime() + "." + suffix;

        File localFile = new File(folder, newFileName);
        file.transferTo(localFile);

        return new FileInfo(1, "上传成功", request.getRequestURL().substring(0,request.getRequestURL().lastIndexOf("/"))+"/upload/"+newFileName);
    }

}
