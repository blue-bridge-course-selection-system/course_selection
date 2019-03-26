package cn.wisdsoft.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Author     ：高伟萌.
 * @ Date       ：Created in 2019-03-26 14:16
 * @ Description：
 */
@RestController
@RequestMapping("/admin")
public class IndexController {

    @GetMapping("/index")
    public String index(){
        return "administrator";
    }
}
