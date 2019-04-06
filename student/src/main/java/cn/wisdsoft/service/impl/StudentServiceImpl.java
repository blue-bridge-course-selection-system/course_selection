package cn.wisdsoft.service.impl;

import cn.wisdsoft.mapper.StudentMapper;
import cn.wisdsoft.pojo.StudentElectiveEntity;
import cn.wisdsoft.pojo.StudentEntity;
import cn.wisdsoft.service.StudentService;
import cn.wisdsoft.util.ElectiveResult;
import org.springframework.stereotype.Service;

/**
 * @ Author     ：高伟萌.
 * @ Date       ：Created in 2019-03-29 08:15
 * @ Description：
 */
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public ElectiveResult login(String username, String password) {
        StudentEntity student = studentMapper.selectByUsernameAndPassword(username, password);
        return ElectiveResult.ok(student);
    }

    @Override
    public ElectiveResult insert(StudentEntity student) {
        studentMapper.insertOne(student);
        return ElectiveResult.ok();
    }

    @Override
    public ElectiveResult insertStudentElective(StudentElectiveEntity electiveEntity) {
        return null;
    }
}
