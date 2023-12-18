package org.example.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 曾文亮
 * @version 1.0.0
 * @email wenliang_zeng416@163.com
 * @date 2023年12月18日 22:07:13
 * @packageName org.example.Controller
 * @className HelloController
 * @describe TODO
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public Object hello(@RequestParam(value = "name") String name) {
        return "Hello" + name;
    }
}
