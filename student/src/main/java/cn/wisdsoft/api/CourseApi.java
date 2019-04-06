package cn.wisdsoft.api;

import cn.wisdsoft.util.ElectiveResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Author     ：高伟萌.
 * @ Date       ：Created in 2019-04-04 08:24
 * @ Description：
 */
@RestController
@RequestMapping("/course")
public class CourseApi {
    /**
     * 查看是否处于选课阶段
     * @param token 用户令牌
     * @param termId 学期ID
     * @return JSON数据
     */
    @GetMapping("/stage/{token}/{termId}")
    public ElectiveResult selectStage(@PathVariable("token") String token,@PathVariable("termId") Integer termId){
        return null;
    }
}
