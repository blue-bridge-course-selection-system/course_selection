package cn.wisdsoft.api;

import cn.wisdsoft.service.TeacherService;
import cn.wisdsoft.util.ElectiveResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Author     ：高伟萌.
 * @ Date       ：Created in 2019-04-03 09:46
 * @ Description：
 */
@RestController
public class TeacherLoginApi {
    private final TeacherService teacherService;

    public TeacherLoginApi(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    /**
     * 根据工号和密码查询教师
     * @param username 工号
     * @param password 密码
     * @return JSON数据
     */
    @PostMapping("/selectTeacher")
    public ElectiveResult selectOne(String username, String password) {
        return teacherService.selectOne(username, password);
    }
}
