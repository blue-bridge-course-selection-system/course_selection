package cn.wisdsoft.api;

import cn.wisdsoft.feign.StudentFeign;
import cn.wisdsoft.util.ElectiveResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Author     ：高伟萌.
 * @ Date       ：Created in 2019-03-29 09:13
 * @ Description：
 */
@RestController
@RequestMapping("/student/view")
public class StudentViewController {
    private final StudentFeign studentFeign;

    public StudentViewController(StudentFeign studentFeign) {
        this.studentFeign = studentFeign;
    }

    @PostMapping("/login")
    public ElectiveResult login(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("token") String token){
        return studentFeign.login(username, password, token);
    }
}
