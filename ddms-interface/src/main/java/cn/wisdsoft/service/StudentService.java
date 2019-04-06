package cn.wisdsoft.service;

import cn.wisdsoft.util.ElectiveResult;

/**
 * @ Author     ：高伟萌.
 * @ Date       ：Created in 2019-04-02 13:24
 * @ Description：
 */
public interface StudentService {
    ElectiveResult selectOne(String username, String password);
}
