package cn.wisdsoft.fallback;

import cn.wisdsoft.feign.StudentFeign;
import cn.wisdsoft.util.ElectiveResult;
import org.springframework.stereotype.Component;

/**
 * @ Author     ：高伟萌.
 * @ Date       ：Created in 2019-03-29 09:22
 * @ Description：
 */
@Component
public class StudentFallBack implements StudentFeign {
    @Override
    public ElectiveResult login(String username, String password, String token) {
        return ElectiveResult.build(410,"服务器忙，请稍后再试！");
    }
}
