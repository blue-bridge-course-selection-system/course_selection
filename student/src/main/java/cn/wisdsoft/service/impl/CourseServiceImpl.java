package cn.wisdsoft.service.impl;

import cn.wisdsoft.mapper.CourseMapper;
import cn.wisdsoft.service.CourseService;
import cn.wisdsoft.util.ElectiveResult;
import cn.wisdsoft.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ Author     ：高伟萌.
 * @ Date       ：Created in 2019-04-10 16:58
 * @ Description：
 */
@Service
public class CourseServiceImpl implements CourseService {
    private final CourseMapper courseMapper;

    public CourseServiceImpl(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }


    @Override
    public PageResult allCourse(Integer grade, String nature, String volume, String locations, String time, Integer page, Integer limit) {

        return null;
    }
}
