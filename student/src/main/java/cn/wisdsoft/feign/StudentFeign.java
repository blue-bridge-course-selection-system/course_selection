package cn.wisdsoft.feign;

import cn.wisdsoft.fallback.StudentFallBack;
import cn.wisdsoft.util.ElectiveResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ Author     ：高伟萌.
 * @ Date       ：Created in 2019-04-02 15:50
 * @ Description：
 */
@FeignClient(value = "DDMS-INTERFACE",fallback = StudentFallBack.class)
@Component
public interface StudentFeign {

    /**
     * 调用远程学生登录接口
     * @param username 学号
     * @param password 密码
     * @return JSON数据
     */
    @PostMapping("/selectStudent")
    ElectiveResult selectOne(@RequestParam("username") String username, @RequestParam("password") String password);
}
