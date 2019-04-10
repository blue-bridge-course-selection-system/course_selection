package cn.wisdsoft.service;

import cn.wisdsoft.util.ElectiveResult;
import cn.wisdsoft.util.PageResult;

/**
 * @ Author     ：高伟萌.
 * @ Date       ：Created in 2019-04-10 16:57
 * @ Description：
 */
public interface CourseService {
    /**
     * 查询所有课程
     *
     * @param grade     年级
     * @param nature    课程类别（school-》校选；college-》院选；all-》所有）
     * @param volume    容量（all-》所有；have-》有；nothave-》无）
     * @param locations 地点（all-》所有；其他对应楼号）
     * @param time      上课时间（all-》所有；其他对应星期）
     * @param page      当前页数
     * @param limit     每页数量
     * @return 课程信息
     */
    PageResult allCourse(Integer grade, String nature, String volume,
                         String locations, String time, Integer page, Integer limit);
}
