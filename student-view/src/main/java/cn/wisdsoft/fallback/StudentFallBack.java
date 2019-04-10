package cn.wisdsoft.fallback;

import cn.wisdsoft.feign.StudentFeign;
import cn.wisdsoft.util.ElectiveResult;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * @ Author     ：高伟萌.
 * @ Date       ：Created in 2019-03-29 09:22
 * @ Description：
 */
@Component
public class StudentFallBack implements StudentFeign {
    @Override
    public ElectiveResult login(String username, String password, String token) {
        return ElectiveResult.build(410,"服务器忙，请稍后再试！");
    }

    @Override
    public ElectiveResult getCourse(String token, Long electiveCourseId, String courseGroupId, HttpSession session) {
        return ElectiveResult.build(410,"服务器忙，请稍后再试！");
    }

    @Override
    public ElectiveResult dropCourse(String token, Long electiveCourseId, HttpSession session) {
        return ElectiveResult.build(410,"服务器忙，请稍后再试！");
    }

    @Override
    public ElectiveResult myCourse(String token, String courseFlag, HttpSession session) {
        return ElectiveResult.build(410,"服务器忙，请稍后再试！");
    }
}
