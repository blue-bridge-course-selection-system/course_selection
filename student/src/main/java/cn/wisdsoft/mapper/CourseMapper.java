package cn.wisdsoft.mapper;

import cn.wisdsoft.mapper.SQL.SQLUtil;
import cn.wisdsoft.pojo.ElectiveCourseEntity;
import cn.wisdsoft.pojo.ElectiveCourseDo;
import cn.wisdsoft.pojo.TermEntity;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * @ Author     ：高伟萌.
 * @ Date       ：Created in 2019-04-10 10:39
 * @ Description：
 */
public interface CourseMapper {
    /**
     * 查询课程
     *
     * @param grade    年级
     * @param termId   学期ID
     * @param college  学院
     * @param volume   有无容量
     * @param nature   课程性质
     * @param week     星期
     * @param location 地点
     * @return 课程列表
     */
//    @Select("<script>" +
//            "SELECT elective_course_id, course_library_id," +
//            "course_library_name, course_group_name," +
//            "teacher_name, time_json, locations_json," +
//            "max_number, min_number, class_hour," +
//            "credit, course_library_introduction, current_number" +
//            "FROM elective_course " +
//            "WHERE restricted_grade = #{grade} " +
//            "AND current_number != 0 " +
//            "AND term_id = #{termId}" +
//            "AND college_name = #{college}" +
//            "AND delete_flag = 0" +
//            "ORDER BY current_number DESC" +
//            "</script>")
    @SelectProvider(type = SQLUtil.class, method = "allCourse")
    List<ElectiveCourseDo> allCourse(Integer grade, Integer termId, String college, String volume, String nature, String week, String location);

    /**
     * 查询备选课程
     * @param grade 年级
     * @param termId 学期
     * @param college 学院
     * @return 课程列表
     */
    @SelectProvider(type = SQLUtil.class, method = "optionCourse")
    List<ElectiveCourseDo> optionCourse(Integer grade, Integer termId, String college);

    /**
     * 查询是否可以选课
     * @param termId 学期ID
     * @return 学期实体类
     */
    @Select("select * from term where term_status = 2 and termId = #{termId}")
    TermEntity selectOne(Integer termId);
}
