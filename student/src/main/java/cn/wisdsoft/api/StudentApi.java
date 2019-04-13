package cn.wisdsoft.api;

import cn.wisdsoft.pojo.*;
import cn.wisdsoft.util.ElectiveResult;
import cn.wisdsoft.util.MD5Util;
import cn.wisdsoft.feign.StudentFeign;
import cn.wisdsoft.service.StudentService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.UUID;

/**
 * @ Author     ：高伟萌.
 * @ Date       ：Created in 2019-03-26 14:17
 * @ Description：
 */
@RestController
@RequestMapping("/student")
public class StudentApi {
    private final StudentFeign studentFeign;

    private final StudentService studentService;

    public StudentApi(StudentFeign studentFeign, StudentService studentService) {
        this.studentFeign = studentFeign;
        this.studentService = studentService;
    }

    /**
     * 学生登录
     *
     * @param username 学号
     * @param password 密码
     * @param session  session
     * @return JSON数据
     */
    @PostMapping("/slogin")
    public ElectiveResult login(String username, String password, HttpSession session) {
        //缺少学期，远程调用接口 TODO
        String term = "2018-2019第一学期";
        Integer termId = 1;

        //自定义返回数据
        StudentVo studentVo = new StudentVo();

        //将输入的密码加密
        String md5Encryption = MD5Util.MD5Encryption(password);

        //查询本地表内是否有该学生
        ElectiveResult result = studentService.login(username, md5Encryption);

        //生成token
        String token = UUID.randomUUID().toString().replaceAll("-", "");

        StudentEntity student;

        //如果没有，则去ddms查询，之后插入本地数据库；如果有，则返回
        if (result.getData() == null) {
            //调用DDMS的查询学生方法
            ElectiveResult electiveResult = studentFeign.selectOne(username, password);
            if (electiveResult.getStatus() == 200 && electiveResult.getData() == null) {
                return ElectiveResult.build(410, "用户名或密码错误！");
            } else if (electiveResult.getStatus() == 510) {
                return ElectiveResult.build(510, electiveResult.getMsg());
            } else {
                StudentDo studentDo = JSONObject.parseObject(JSON.toJSONString(electiveResult.getData()), StudentDo.class);
                //将DDMS的学生密码加密
                String encryption = MD5Util.MD5Encryption(studentDo.getStuPassword());
                StudentEntity student1 = new StudentEntity();
                student1.setStudentId(studentDo.getId()).setStudentPassword(encryption)
                        .setStudentName(studentDo.getStuName()).setCollegeName(studentDo.getCollegeName())
                        .setGrade(Short.valueOf(studentDo.getId().substring(0, 2)));
                //插入本地数据库
                studentService.insert(student1);
                studentVo.setUsername(student1.getStudentId()).setName(student1.getStudentName())
                        .setCollege(student1.getCollegeName()).setTermId(termId).setTerm(term).setToken(token);
            }
        } else {
            student = JSONObject.parseObject(JSON.toJSONString(result.getData()), StudentEntity.class);
            studentVo.setUsername(student.getStudentId()).setName(student.getStudentName())
                    .setCollege(student.getCollegeName()).setTermId(termId).setTerm(term).setToken(token);
        }
        //将用户信息存到Session中
        session.setAttribute(token, studentVo);
        //自定义返回实体类
        return ElectiveResult.ok(studentVo);
    }

    /**
     * 选择课程
     *
     * @param token            用户令牌
     * @param electiveCourseId 选课ID
     * @param courseGroupName  课组名称
     * @param session          session
     * @return JSON数据
     */
    @PostMapping("/getcourse")
    public ElectiveResult getCourse(String token, Long electiveCourseId, String courseGroupName, HttpSession session) {
        StudentVo studentVo = (StudentVo) session.getAttribute(token);
        if (studentVo == null) {
            return ElectiveResult.build(410, "token失效");
        }
        StudentElectiveEntity entity = new StudentElectiveEntity();
        entity.setElectiveCourseId(electiveCourseId).setStudentId(studentVo.getUsername()).setStudentName(studentVo.getName())
                .setCourseFlag("learning").setTimeStamp(new Date());
        return studentService.insertStudentElective(entity, studentVo.getCollege(), courseGroupName);
    }

    /**
     * 退课
     *
     * @param token            用户令牌
     * @param electiveCourseId 选课ID
     * @param session          session
     * @return JSON数据
     */
    @PostMapping("/dropcourse")
    public ElectiveResult dropCourse(String token, Long electiveCourseId, HttpSession session) {
        StudentVo studentVo = (StudentVo) session.getAttribute(token);
        if (studentVo == null) {
            return ElectiveResult.build(410, "token失效");
        }
        studentService.deleteCourse(studentVo.getUsername(), electiveCourseId);
        return ElectiveResult.ok();
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
    public ElectiveResult myCourse(String token, String courseFlag, HttpSession session) {
        StudentVo myToken = (StudentVo) session.getAttribute(token);
        if (myToken == null) {
            return ElectiveResult.build(410, "token失效");
        }
        String studentId = myToken.getUsername();
        return studentService.selectElectiveCourse(courseFlag, studentId);
    }

}
