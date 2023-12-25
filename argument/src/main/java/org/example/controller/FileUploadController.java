package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class FileUploadController {
    private final static Logger logging = Logger.getLogger(FileUploadController.class.getName());

    /**
     * 首先根据此方法跳转到upload.html界面
     *
     * @return
     */
    @GetMapping(value = "/upload_pre")
    public String uploadPre() {
        return "upload";
    }

    @PostMapping("/upload")
    public Object upload(String name, @RequestParam(value = "multipartFile") MultipartFile multipartFile)
            throws IllegalStateException, IOException {
        Map<String, Object> map = new HashMap<>();
        if (multipartFile != null) {
            // 设置文件名称
            map.put("nameParam", name);
            // 设置文件名称
            map.put("fileame", multipartFile.getOriginalFilename());
            logging.log(Level.INFO, "fileame：{0}", multipartFile.getOriginalFilename());
            // 设置文件类型
            map.put("contentType", multipartFile.getContentType());
            // 设置文件大小
            map.put("fileSize", multipartFile.getSize());
            // 创建文件名称
            String fileName = "";
            try {
                fileName = UUID.randomUUID() + "."
                        + multipartFile.getContentType().substring(multipartFile.getContentType().lastIndexOf("/") + 1);
            }catch (NullPointerException e){
                logging.log(Level.WARNING, "文件上传异常：{0}",e.getMessage());
            }
            // 获取到文件的路径信息
            String filePath = "D:\\workspace\\workDemo\\argument\\"+ fileName;
            // 打印保存路径
            logging.log(Level.INFO, "filePath：{0}", filePath);
            // 保存文件的路径信息
            map.put("filePath", filePath);
            // 创建文件
             File saveFile = new File(filePath);
             // 文件保存
             multipartFile.transferTo(saveFile);
            return map;
        } else {
            return "no file ";
        }
    }
}