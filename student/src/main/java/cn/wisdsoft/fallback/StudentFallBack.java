package cn.wisdsoft.fallback;

import cn.wisdsoft.feign.StudentFeign;
import cn.wisdsoft.util.ElectiveResult;
import org.springframework.stereotype.Component;

/**
 * @ Author     ：高伟萌.
 * @ Date       ：Created in 2019-04-02 15:59
 * @ Description：
 */
@Component
public class StudentFallBack implements StudentFeign {
    @Override
    public ElectiveResult selectOne(String username, String password) {
        return ElectiveResult.build(510,"服务器忙，请稍后再试！");
    }
}
