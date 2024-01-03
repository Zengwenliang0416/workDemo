package org.example.controller;

import org.example.utils.Utils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author 曾文亮
 * @version 1.0.0
 * @email wenliang_zeng416@163.com
 * @date 2023年12月21日 22:06:09
 * @packageName org.example.Controller
 * @className TextPostController
 * @describe 测试文本上传
 */
@RestController
public class TextPostController {
    @PostMapping("/text")
    public String textPost(@RequestParam(value = "text", required = false) String text) {
        return text;
    }
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public ResponseEntity<String> handleRequest(@RequestBody String requestBody) {
        // 在这里处理请求正文
        // 如果需要验证数据或执行其他操作，可以在这里进行逻辑处理

        // 发送错误响应
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
    }
}
