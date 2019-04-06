package cn.wisdsoft.service;

import cn.wisdsoft.pojo.StudentElectiveEntity;
import cn.wisdsoft.pojo.StudentEntity;
import cn.wisdsoft.util.ElectiveResult;

/**
 * @ Author     ：高伟萌.
 * @ Date       ：Created in 2019-03-29 08:13
 * @ Description：
 */
public interface StudentService {
    /**
     * 登录方法
     * @param username 学号
     * @param password 密码
     * @return JSON数据
     */
    ElectiveResult login(String username, String password);

    /**
     * 插入学生信息
     * @param student 学生实体类
     * @return JSON数据
     */
    ElectiveResult insert(StudentEntity student);

    /**
     * 插入学生选课信息
     * @param electiveEntity 学生选课子表对象
     * @return JSON数据
     */
    ElectiveResult insertStudentElective(StudentElectiveEntity electiveEntity);
}
