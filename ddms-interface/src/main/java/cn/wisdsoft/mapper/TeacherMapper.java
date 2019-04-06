package cn.wisdsoft.mapper;

import cn.wisdsoft.pojo.Teacher;
import org.apache.ibatis.annotations.Select;

/**
 * @ Author     ：高伟萌.
 * @ Date       ：Created in 2019-04-03 09:40
 * @ Description：
 */
public interface TeacherMapper {
    @Select("select " +
            "tea_power,workNumber,tea_Name,tea_picture,tea_Sex,tea_phone,tea_degreeEdu,tea_jobTitle,remark" +
            " from teacher where workNumber = #{username} and tea_password = #{password}")
    Teacher selectOne(String username, String password);
}
