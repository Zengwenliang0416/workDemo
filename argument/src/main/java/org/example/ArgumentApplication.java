package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD

@SpringBootApplication
public class ArgumentApplication {
    public static void main(String[] args) {
        SpringApplication.run(ArgumentApplication.class,args);
=======
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 曾文亮
 * @version 1.0.0
 * @email wenliang_zeng416@163.com
 * @date 2023年12月21日 22:02:24
 * @packageName org.example
 * @className ArgumentApplication
 * @describe 参数测试应用
 */
@SpringBootApplication
@RestController
public class ArgumentApplication {
    public static void main(String[] args) {
        SpringApplication.run(ArgumentApplication.class, args);
    }
    @PostMapping("/")
    public String processRequest(@RequestBody String requestBody) {
        // 不读取请求正文
        // 直接发送响应
        return "Response";
>>>>>>> d0a2c0244a33cd01e2dc1b319f6ebd3d97fdc1fe
    }
}
