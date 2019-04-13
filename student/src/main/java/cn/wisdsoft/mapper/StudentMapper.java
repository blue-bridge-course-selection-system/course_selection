package cn.wisdsoft.mapper;

import cn.wisdsoft.pojo.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @ Author     ：高伟萌.
 * @ Date       ：Created in 2019-03-29 08:16
 * @ Description：
 */
public interface StudentMapper {
    /**
     * 查询学生信息
     *
     * @param username 用户名
     * @param password 密码
     * @return 学生对象
     */
    @Select("select * from student where student_id = #{username} and student_password = #{password}")
    StudentEntity selectByUsernameAndPassword(String username, String password);

    /**
     * 插入学生信息
     *
     * @param student 学生对象
     * @return 成功返回1，否则返回0
     */
    @Insert("insert into student(student_id,student_name,student_password,college_name,grade) " +
            "values(#{studentId},#{studentName},#{studentPassword},#{collegeName},#{grade})")
    Integer insertOne(StudentEntity student);

    /**
     * 插入学生选课信息
     *
     * @param electiveEntity 学生选课子表对象
     * @return 成功返回1，否则返回0
     */
    @Insert("insert into student_elective(student_id,elective_course_id,student_name,course_flag,time_stamp,remark) " +
            "values(#{studentId},#{electiveCourseId},#{studentName},#{courseFlag},#{timeStamp},#{remark})")
    Integer insertElectiveCourse(StudentElectiveEntity electiveEntity);

    /**
     * 查询学生已选课程
     *
     * @param studentId 学生学号
     * @param learnFlag 是否正在学习
     * @return 课程列表
     */
    @Select("<script>" +
            "SELECT s.elective_course_id,course_library_id,course_library_name,teacher_name,class_time," +
            "class_locations,class_hour,credit,time_stamp,course_flag FROM student_elective AS s,elective_course AS e " +
            "WHERE student_id = #{studentId} AND s.elective_course_id = e.elective_course_id " +
            "<if test='learnFlag != all'>" +
            "AND course_flag = #{learnFlag}" +
            "</if>" +
            "</script>")
    List<StudentElectiveVo> selectElectiveCourse(String studentId, String learnFlag);

    /**
     * 查询学生的选课条数
     *
     * @param studentId 学生ID
     * @param college   学院名称
     * @return 选课数量
     */
    @Select("select " +
            "count(*) from student_elective s,elective_course e " +
            "where s.elective_course_id = e.elective_course_id and s.student_id = #{studentId} and e.college_name = #{college}")
    Integer selectCountForElective(String studentId, String college);

    /**
     * 查询学生所选课程对应的课程组
     *
     * @param studentId 学生ID
     * @return 集合
     */
    @Select("select " +
            "DISTINCT course_group_name from student_elective s,elective_course e " +
            "where s.elective_course_id = e.elective_course_id and s.student_id = #{studentId}")
    List<String> selectCourseGroups(String studentId);

    /**
     * 查询课程是否已选满
     *
     * @param electiveCourseId 选课ID
     * @return ElectiveCourseEntity对象
     */
    @Select("select * from elective_course " +
            "where elective_course_id = #{electiveCourseId} and max_number = current_number;")
    ElectiveCourseEntity selectAllNums(Long electiveCourseId);

    /**
     * 更新选课表的当前人数
     *
     * @param electiveCourseId 选课ID
     * @param num              数量
     * @return 成功返回1，否则返回0
     */
    @Select("update elective_course set current_number = elective_course + #{num} where elective_course_id = #{electiveCourseId}")
    Integer updateCurrentNum(Long electiveCourseId, Integer num);

    /**
     * 查询学生选课
     *
     * @param studentId        学号
     * @param electiveCourseId 选课ID
     * @return StudentElectiveEntity对象
     */
    @Select("select * from student_elective where student_id = #{studentId} and elective_course_id = #{electiveCourseId}")
    StudentElectiveEntity selectOne(String studentId, Long electiveCourseId);

    /**
     * 删除选课信息
     *
     * @param studentId        学生ID
     * @param electiveCourseId 选课ID
     * @return 成功返回1，否则返回0
     */
    @Delete("delete from student_elective where student_id = #{studentId} and elective_course_id = #{electiveCourseId}")
    Integer deleteOne(String studentId, Long electiveCourseId);

    /**
     * 将备选状态改为0（表示已选满）
     *
     * @param electiveCourseId 选课ID
     * @return 成功返回1，否则返回0
     */
    @Update("update elective_course set option_flag = 0 where elective_course_id = #{electiveCourseId}")
    Integer updateOptionFlag(Long electiveCourseId);

    /**
     * 查询某一条选课信息
     *
     * @param electiveCourseId 选课ID
     * @return 课程信息
     */
    @Select("select * from elective_course where elective_course_id = #{electiveCourseId}")
    ElectiveCourseEntity selectOne(Long electiveCourseId);
}
