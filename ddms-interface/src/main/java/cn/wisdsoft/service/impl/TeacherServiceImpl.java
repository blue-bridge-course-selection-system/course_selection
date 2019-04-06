package cn.wisdsoft.service.impl;

import cn.wisdsoft.mapper.TeacherMapper;
import cn.wisdsoft.service.TeacherService;
import cn.wisdsoft.util.ElectiveResult;
import org.springframework.stereotype.Service;

/**
 * @ Author     ：高伟萌.
 * @ Date       ：Created in 2019-04-03 09:45
 * @ Description：
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherMapper teacherMapper;

    public TeacherServiceImpl(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }

    @Override
    public ElectiveResult selectOne(String username, String password) {
        return ElectiveResult.ok(teacherMapper.selectOne(username, password));
    }
}
