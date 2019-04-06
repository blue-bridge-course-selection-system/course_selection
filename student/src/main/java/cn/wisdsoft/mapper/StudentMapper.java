package cn.wisdsoft.mapper;

import cn.wisdsoft.pojo.StudentElectiveEntity;
import cn.wisdsoft.pojo.StudentEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * @ Author     ：高伟萌.
 * @ Date       ：Created in 2019-03-29 08:16
 * @ Description：
 */
public interface StudentMapper {
    /**
     * 查询学生信息
     * @param username 用户名
     * @param password 密码
     * @return 学生对象
     */
    @Select("select * from student where student_id = #{username} and student_password = #{password}")
    StudentEntity selectByUsernameAndPassword(String username, String password);

    /**
     * 插入学生信息
     * @param student 学生对象
     * @return 成功返回1，否则返回0
     */
    @Insert("insert into student(student_id,student_name,student_password,college_name,grade) " +
            "values(#{studentId},#{studentName},#{studentPassword},#{collegeName},#{grade})")
    Integer insertOne(StudentEntity student);

    /**
     * 插入学生选课信息
     * @param electiveEntity 学生选课子表对象
     * @return 成功返回1，否则返回0
     */
    @Insert("insert into student_elective(student_id,elective_course_id,student_name,course_flag,time_stamp,remark) " +
            "values(#{studentId},#{electiveCourseId},#{studentName},#{courseFlag},#{timeStamp},#{remark})")
    Integer insertElectiveCourse(StudentElectiveEntity electiveEntity);
}
