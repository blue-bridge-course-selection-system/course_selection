package cn.wisdsoft.mapper.SQL;

import org.apache.ibatis.jdbc.SQL;

/**
 * @ Author     ：高伟萌.
 * @ Date       ：Created in 2019-04-12 08:20
 * @ Description：
 */
public class SQLUtil {
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
     * @return 对应sql语句
     */
    public String allCourse(Integer grade, Integer termId, String college, String volume, String nature, String week, String location) {
        return new SQL() {
            {
                SELECT("elective_course_id, course_library_id");
                SELECT("course_library_name, course_group_name");
                SELECT("teacher_name, time_and_place");
                SELECT("max_number, min_number, class_hour");
                SELECT("credit, course_library_introduction, current_number");
                FROM("elective_course");
                WHERE("restricted_grade = " + grade);
                WHERE("option_flag = 1");
                WHERE("college_name = " + college);
                WHERE("term_id = " + termId);
                WHERE("delete_flag = 0");
                if ((volume != null || !volume.equals("")) && !volume.equals("all")) {
                    if (volume.equals("have")) {
                        WHERE("current_number < max_number");
                    } else if (volume.equals("nothave")) {
                        WHERE("current_number = max_number");
                    }
                }
                if ((nature != null || !nature.equals("")) && !nature.equals("all")) {
                    WHERE("college_name = " + nature);
                }
                if ((week != null || !week.equals("")) && !week.equals("all")) {
                    WHERE("time_json LIKE '%" + week + "%'");
                }
                if ((location != null || !location.equals("")) && !location.equals("all")) {
                    WHERE("locations_json LIKE '%" + location + "%'");
                }
                GROUP_BY("course_library_name");
                ORDER_BY("current_number DESC");
            }
        }.toString();
    }

    /**
     * 查询备选课程
     *
     * @param grade   年级
     * @param termId  学期
     * @param college 学院
     * @return 对应sql语句
     */
    public String optionCourse(Integer grade, Integer termId, String college) {
        return new SQL() {
            {
                SELECT("elective_course_id, course_library_id");
                SELECT("course_library_name, course_group_name");
                SELECT("teacher_name, time_and_place");
                SELECT("max_number, min_number, class_hour");
                SELECT("credit, course_library_introduction");
                FROM("elective_course");
                WHERE("option_flag = 0");
                WHERE("restricted_grade = " + grade);
                WHERE("term_id = " + termId);
                WHERE("college_name = " + college);
                WHERE("current_number = 0");
            }
        }.toString();
    }
}
