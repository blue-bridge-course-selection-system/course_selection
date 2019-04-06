package cn.wisdsoft.mapper;

import cn.wisdsoft.pojo.StudentEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * @ Author     ：高伟萌.
 * @ Date       ：Created in 2019-03-29 08:16
 * @ Description：
 */
public interface StudentMapper {
    @Select("select * from student where student_id = #{username} and student_password = #{password}")
    StudentEntity selectByUsernameAndPassword(String username, String password);

    @Insert("insert into student(student_id,student_name,student_password,college_name,grade) " +
            "values(#{studentId},#{studentName},#{studentPassword},#{collegeName},#{grade})")
    Integer insertOne(StudentEntity student);
}
