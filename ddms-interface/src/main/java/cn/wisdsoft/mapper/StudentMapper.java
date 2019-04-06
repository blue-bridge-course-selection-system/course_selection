package cn.wisdsoft.mapper;

import cn.wisdsoft.pojo.Student;
import org.apache.ibatis.annotations.Select;

/**
 * @ Author     ：高伟萌.
 * @ Date       ：Created in 2019-04-02 13:17
 * @ Description：
 */
public interface StudentMapper {
    @Select("select s.id,s.stu_password as stuPassword,s.stu_name as stuName,c.college_name as collegeName\n" +
            "from student s,major m,college c\n" +
            "where s.id = #{username} and stu_password = #{password} and s.stu_majorId = m.id and m.major_collegeid = c.id")
    Student selectOne(String username, String password);
}
