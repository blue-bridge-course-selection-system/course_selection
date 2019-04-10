package cn.wisdsoft.feign;

import cn.wisdsoft.fallback.StudentFallBack;
import cn.wisdsoft.pojo.StudentElectiveEntity;
import cn.wisdsoft.util.ElectiveResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @ Author     ：高伟萌.
 * @ Date       ：Created in 2019-03-29 09:20
 * @ Description：
 */
@FeignClient(value = "student", fallback = StudentFallBack.class)
public interface StudentFeign {

    /**
     * 学生登录
     *
     * @param username 学号
     * @param password 密码
     * @return JSON数据
     */
    @PostMapping("/elective/student/slogin")
    ElectiveResult login(String username, String password, String token);

    /**
     * 选择课程
     *
     * @param token            用户令牌
     * @param electiveCourseId 选课ID
     * @return JSON数据
     */
    @PostMapping("/elective/student/getcourse")
    public ElectiveResult getCourse(String token, Long electiveCourseId, String courseGroupId, HttpSession session);

    /**
     * 退课
     *
     * @param token            用户令牌
     * @param electiveCourseId 选课ID
     * @return JSON数据
     */
    @PostMapping("/elective/student/dropcourse")
    public ElectiveResult dropCourse(String token, Long electiveCourseId, HttpSession session);

    /**
     * 我的选课
     *
     * @param token      用户令牌
     * @param courseFlag 是否正在学习
     * @param session    session
     * @return JSON数据
     */
    @GetMapping("/elective/student/mycourse")
    public ElectiveResult myCourse(String token, String courseFlag, HttpSession session);


//    /**
//     * 选择课程
//     *
//     * @param token            用户令牌
//     * @param electiveCourseId 选课ID
//     * @return JSON数据
//     */
//    @PostMapping("/elective/student/getcourse")
//    public ElectiveResult getCourse(@RequestParam("token") String token, @RequestParam("electiveCourseId") Long electiveCourseId, @RequestParam("courseGroupId") String courseGroupId, @RequestParam("session") HttpSession session);
//
//    /**
//     * 退课
//     *
//     * @param token            用户令牌
//     * @param electiveCourseId 选课ID
//     * @return JSON数据
//     */
//    @PostMapping("/elective/student/dropcourse")
//    public ElectiveResult dropCourse(@RequestParam("token") String token, @RequestParam("electiveCourseId") Long electiveCourseId, @RequestParam("session") HttpSession session);
//
//    /**
//     * 我的选课
//     *
//     * @param token      用户令牌
//     * @param courseFlag 是否正在学习
//     * @param session    session
//     * @return JSON数据
//     */
//    @GetMapping("/elective/student/mycourse")
//    public ElectiveResult myCourse(@RequestParam("token") String token, @RequestParam("courseFlag") String courseFlag, @RequestParam("session") HttpSession session);
}
