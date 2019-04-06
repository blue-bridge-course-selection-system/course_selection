package cn.wisdsoft.service;

import cn.wisdsoft.util.ElectiveResult;

/**
 * @ Author     ：高伟萌.
 * @ Date       ：Created in 2019-04-03 09:44
 * @ Description：
 */
public interface TeacherService {
    ElectiveResult selectOne(String username, String password);
}
