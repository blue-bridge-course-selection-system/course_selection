package cn.wisdsoft.api;

import cn.wisdsoft.feign.StudentFeign;
import cn.wisdsoft.util.ElectiveResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

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

    /**
     * 登录
     *
     * @param username 学号
     * @param password 密码
     * @param token    用户令牌
     * @return JSON数据
     */
    @PostMapping("/login")
    public ElectiveResult login(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("token") String token) {
        return studentFeign.login(username, password, token);
    }

    /**
     * 选择课程
     *
     * @param token            用户令牌
     * @param electiveCourseId 选课ID
     * @return JSON数据
     */
    @PostMapping("/getcourse")
    public ElectiveResult getCourse(@RequestParam("token") String token, @RequestParam("electiveCourseId") Long electiveCourseId, @RequestParam("courseGroupId") String courseGroupId, @RequestParam("session") HttpSession session) {
        return studentFeign.getCourse(token, electiveCourseId, courseGroupId, session);
    }

    /**
     * 退课
     *
     * @param token            用户令牌
     * @param electiveCourseId 选课ID
     * @return JSON数据
     */
    @PostMapping("/dropcourse")
    public ElectiveResult dropCourse(@RequestParam("token") String token, @RequestParam("electiveCourseId") Long electiveCourseId, @RequestParam("session") HttpSession session) {
        return studentFeign.dropCourse(token, electiveCourseId, session);
    }

    /**
     * 我的选课
     *
     * @param token      用户令牌
     * @param courseFlag 是否正在学习
     * @param session    session
     * @return JSON数据
     */
    @GetMapping("/mycourse")
    public ElectiveResult myCourse(@RequestParam("token") String token, @RequestParam("courseFlag") String courseFlag, @RequestParam("session") HttpSession session) {
        return studentFeign.myCourse(token, courseFlag, session);
    }
}
