package cn.wisdsoft.feign;

import cn.wisdsoft.fallback.StudentFallBack;
import cn.wisdsoft.util.ElectiveResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @ Author     ：高伟萌.
 * @ Date       ：Created in 2019-03-29 09:20
 * @ Description：
 */
@FeignClient(value = "student",fallback = StudentFallBack.class)
public interface StudentFeign {

    @PostMapping("/login")
    ElectiveResult login(String username, String password, String token);
}
