package cn.wisdsoft.api;

import cn.wisdsoft.pojo.StudentVo;
import cn.wisdsoft.service.CourseService;
import cn.wisdsoft.util.ElectiveResult;
import cn.wisdsoft.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @ Author     ：高伟萌.
 * @ Date       ：Created in 2019-04-04 08:24
 * @ Description：
 */
@RestController
@RequestMapping("/course")
public class CourseApi {
    private final CourseService courseService;

    public CourseApi(CourseService courseService) {
        this.courseService = courseService;
    }

    /**
     * 查询所有课程
     *
     * @param token     用户令牌
     * @param nature    课程类别（school-》校选；college-》院选；all-》所有）
     * @param volume    容量（all-》所有；have-》有；nothave-》无）
     * @param locations 地点（all-》所有；其他对应楼号）
     * @param time      上课时间（all-》所有；其他对应星期）
     * @param page      当前页数
     * @param limit     每页数量
     * @param session   session
     * @return 课程信息
     */
    @GetMapping("/allcourse")
    public PageResult allCourse(String token, String nature, String volume,
                                String locations, String time, Integer page, Integer limit, HttpSession session) {
        StudentVo studentVo = (StudentVo) session.getAttribute(token);
        if (studentVo == null) {
            return PageResult.build(410, "token失效");
        }
        page = page == 0 ? 1 : page;
        limit = limit == 0 ? 5 : limit;
        return courseService.allCourse(Integer.valueOf(studentVo.getUsername().substring(0, 2)), studentVo.getTermId(), studentVo.getCollege(),
                nature, volume, locations, time, page, limit);
    }

    /**
     * 查询所有备选课程
     *
     * @param token   用户令牌
     * @param page    当前页数
     * @param limit   每页数量
     * @param session session
     * @return
     */
    @GetMapping("/optioncourse")
    public PageResult optionCourse(String token, Integer page, Integer limit, HttpSession session) {
        StudentVo studentVo = (StudentVo) session.getAttribute(token);
        if (studentVo == null) {
            return PageResult.build(410, "token失效");
        }
        page = page == 0 ? 1 : page;
        limit = limit == 0 ? 5 : limit;
        return courseService.optionCourse(Integer.valueOf(studentVo.getUsername().substring(0, 2)), studentVo.getTermId(),
                studentVo.getCollege(), page, limit);
    }
}
