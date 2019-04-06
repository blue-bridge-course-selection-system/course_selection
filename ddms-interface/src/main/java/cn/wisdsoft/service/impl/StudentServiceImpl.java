package cn.wisdsoft.service.impl;

import cn.wisdsoft.mapper.StudentMapper;
import cn.wisdsoft.service.StudentService;
import cn.wisdsoft.util.ElectiveResult;
import org.springframework.stereotype.Service;

/**
 * @ Author     ：高伟萌.
 * @ Date       ：Created in 2019-04-02 13:25
 * @ Description：
 */
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public ElectiveResult selectOne(String username, String password) {
        return ElectiveResult.ok(studentMapper.selectOne(username, password));
    }
}
